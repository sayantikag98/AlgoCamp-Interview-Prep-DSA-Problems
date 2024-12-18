package LinkedList.DoublyLinkedList;

class Node {
    int val;
    Node prev;
    Node next;

    Node(){
        this.val = 0;
        this.prev = null;
        this.next = null;
    }

    Node(int val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    Node(int val, Node prev, Node next){
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
