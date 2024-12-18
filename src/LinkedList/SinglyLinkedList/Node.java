package LinkedList.SinglyLinkedList;

class Node {
    int val;
    Node next;

    Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

    Node(int val){
        this.val = val;
        this.next = null;
    }

    Node(){
        this.val = 0;
        this.next = null;
    }
}
