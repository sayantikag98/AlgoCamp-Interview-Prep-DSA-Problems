package LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    //insert at head
    Node insertAtHead(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        if(head != null) head.prev = newNode;
        else tail = newNode;
        head = newNode;
        return head;
    }

    //insert at tail
    Node insertAtTail(int val){
        if(head == null) return insertAtHead(val);
        Node newNode = new Node(val);
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
        return head;
    }

    //insert at pos k
    Node insertAtPos(int val, int k){
        if(k>=1){
            Node temp = head;
            int count = 1;
            while(temp != null && count < k){
                temp = temp.next;
                count++;
            }
            if(temp == null){
                if(count == k) return insertAtTail(val);
                return head;
            }
            if(temp == head) return insertAtHead(val);

            Node newNode = new Node(val);
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev = newNode;
            newNode.prev.next = newNode;
        }
        return head;
    }


    //delete at head
    Node deleteAtHead(){
        if(head == null) return null;
        head = head.next;
        if(head != null) head.prev = null;
        else tail = null;
        return head;
    }

    //delete at tail
    Node deleteAtTail(){
        if(head == null || head.next == null) {
            return this.deleteAtHead();
        }
        tail = tail.prev;
        tail.next = null;
        return head;
    }

    //delete a val
    Node deleteAVal(int val){
        Node temp = head;
        while(temp != null && temp.val != val){
            temp = temp.next;
        }
        if(temp == null) return head;
        if(temp == head) return deleteAtHead();
        if(temp == tail) return deleteAtTail();

        //val is present, and it's not at head or tail

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return head;
    }


    //delete at pos k
    Node deleteAtPos(int k){
        if(k>=1){
            int count = 1;
            Node temp = head;
            while(temp != null && count<k){
                temp = temp.next;
                count++;
            }
            if(temp == null) return head;
            if(temp == head) return deleteAtHead();
            if(temp == tail) return deleteAtTail();

            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        return head;
    }

    boolean isEmpty(){
        return head == null;
    }

    Node getHead(){
        return this.head;
    }

    Node getTail(){
        return this.tail;
    }

    void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " <=> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
