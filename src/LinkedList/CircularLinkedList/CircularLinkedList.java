package LinkedList.CircularLinkedList;

class CircularLinkedList {
    Node head;

    CircularLinkedList(){
        this.head = null;
    }

    //EVERY SINGLE FUNCTION IS OF O(N)

    //insert at head
    void insertAtHead(int val){
        Node newNode = new Node(val);
        if(head == null){
            newNode.next = newNode;
        }
        else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
        }
        head = newNode;
    }


    //insert at tail
    void insertAtTail(int val){
        if(head == null || head.next == null){
            insertAtTail(val);
            return;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.next = head;
    }


    //insertAtPos
    void insertAtPos(int val, int k){
        if(k<1 || (head == null && k>1)) return;
        if(k == 1){
            insertAtHead(val);
        }
        else{
            int count = 2;
            Node temp = head;

            while(temp.next != head && count<k){
                temp = temp.next;
                count++;
            }

            if(temp.next == head){
                if(count == k){
                    insertAtTail(val);
                }
                else return;
            }

            //temp is the node previous to the position where new node should be added
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
        }

    }

    //deleteAtHead
    void deleteAtHead(){
        if(head == null) return;
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
    }

    //deleteAtTail
    void deleteAtTail(){
        if(head == null || head.next == null){
            deleteAtHead();
            return;
        }
        Node temp = head;
        while(temp.next.next != head){
            temp = temp.next;
        }
        temp.next = head;
    }

    //deleteAtPos
    void deleteAtPos(int k){
        if(k<1 || head == null) return;
        if(k == 1){
            deleteAtHead();
        }
        else{
            if(head.next == null) return;
            Node temp = head;
            int count = 2;
            while(temp.next != head && count<k){
                temp = temp.next;
                count++;
            }

            if(temp.next == head){
                return;
            }

            temp.next = temp.next.next;
        }
    }

    void deleteAVal(int val){
        if(head == null) return;
        Node temp = head;
        while(temp.next != head && temp.next.val != val){
            temp = temp.next;
        }
        if(temp.next.val == val){
            if(temp.next == head){
                deleteAtHead();
                return;
            }
            temp.next = temp.next.next;
        }
    }

    void print(){
        if(head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        while(temp.next != head){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.print(temp.val+ " -> ");
        System.out.println(temp.next.val);
    }
}
