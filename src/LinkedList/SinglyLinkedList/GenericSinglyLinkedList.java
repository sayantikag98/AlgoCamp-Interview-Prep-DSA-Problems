package LinkedList.SinglyLinkedList;

class GenericSinglyLinkedList<T> {
    GenericNode<T> head;
    int size;

    GenericSinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    int getSize(){
        return this.size;
    }

    boolean isEmpty(){
        return this.head == null;
    }

    GenericNode<T> getHead(){
        return this.head;
    }

    void insertAtHead(T val){
        GenericNode<T> newNode = new GenericNode<>(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    void insertAtTail(T val){
        if(this.isEmpty()) this.insertAtHead(val);
        else{
            GenericNode<T> newNode = new GenericNode<>(val), temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            size++;
        }
    }

    void insertAtPosition(T val, int pos){
        if(pos < 1 || pos > size + 1){
            System.out.println("position is invalid");
            return;
        }
        if(pos == 1){
            insertAtHead(val);
        }
        else if(pos == size+1){
            insertAtTail(val);
        }
        else{
            GenericNode<T> temp = head, newNode = new GenericNode<>(val);
            while(--pos>1){
                temp = temp.next;
            }
            GenericNode<T> nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
            size++;
        }
    }

    GenericNode<T> deleteAtHead(){
        if(this.isEmpty()){
            System.out.println("Linked list is empty");
            return null;
        }
        else{
            GenericNode<T> temp = head;
            head = head.next;
            size--;
            temp.next = null;
            return temp;
        }
    }

    GenericNode<T> deleteAtTail(){
        if(size == 0 || size == 1) {
            return deleteAtHead();
        }
        else{
            GenericNode<T> temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            GenericNode<T> deleteNode = temp.next;
            temp.next = null;
            size--;
            return deleteNode;
        }
    }

    GenericNode<T> deleteAtPos(int pos){
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
            GenericNode<T> temp = head;
            while(--pos>1){
                temp = temp.next;
            }
            GenericNode<T> deleteNode = temp.next;
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
        GenericNode<T> temp = head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
