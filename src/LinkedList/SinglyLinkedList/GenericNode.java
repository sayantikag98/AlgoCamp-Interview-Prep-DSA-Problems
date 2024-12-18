package LinkedList.SinglyLinkedList;

class GenericNode<T> {
    T val;
    GenericNode<T> next;

    GenericNode(T val){
        this.val = val;
        this.next = null;
    }
}
