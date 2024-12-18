package LinkedList.SinglyLinkedList;

class SinglyLinkedList {
    Node head;
    int size;

    SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    int getSize(){
        return this.size;
    }

    boolean isEmpty(){
        return this.size == 0;
    }

    Node getHead(){
        return this.head;
    }

    void insertAtHead(Node n){
        n.next = head;
        head = n;
        size++;
    }

    void insertAtTail(Node n){
        if(this.isEmpty()) this.insertAtHead(n);
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = n;
            size++;
        }
    }

    void insertAtPosition(Node n, int pos){
        if(pos < 1 || pos > size + 1){
            System.out.println("position is invalid");
            return;
        }
        if(pos == 1){
            insertAtHead(n);
        }
        else if(pos == size+1){
            insertAtTail(n);
        }
        else{
            Node temp = head;
            while(--pos>1){
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = n;
            n.next = nextNode;
            size++;
        }
    }

    Node deleteAtHead(){
        if(this.isEmpty()){
            System.out.println("Linked list is empty");
            return null;
        }
        else{
            Node temp = head;
            head = head.next;
            size--;
            temp.next = null;
            return temp;
        }
    }

    Node deleteAtTail(){
        if(size == 0 || size == 1) {
            return deleteAtHead();
        }
        else{
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            Node deleteNode = temp.next;
            temp.next = null;
            size--;
            return deleteNode;
        }
    }

    Node deleteAtPos(int pos){
        if(pos < 1 || pos > size){
            System.out.println("position is invalid");
            return null;
        }
        if(pos == 1){
            return deleteAtHead();
        }
        else if(pos == size){
            return deleteAtTail();
        }
        else{
            Node temp = head;
            while(--pos>1){
                temp = temp.next;
            }
            Node deleteNode = temp.next;
            temp.next = temp.next.next;
            size--;
            deleteNode.next = null;
            return deleteNode;
        }
    }

    void print(){
        if(this.isEmpty()){
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
