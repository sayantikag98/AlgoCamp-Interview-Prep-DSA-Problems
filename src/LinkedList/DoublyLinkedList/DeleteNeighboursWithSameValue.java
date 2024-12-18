package LinkedList.DoublyLinkedList;

import static LinkedList.DoublyLinkedList.ConvertArrayToDLL.print;

public class DeleteNeighboursWithSameValue {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
//        dll.insertAtTail();
        dll.insertAtTail(1);
        dll.insertAtTail(1);
        dll.insertAtTail(2);
        dll.insertAtTail(1);

        Node tail = dll.getTail(), head = dll.getHead();


        dll.print();

        deleteNeighbours(head, tail);

        dll.print();

    }

    private static void deleteNeighbours(Node head, Node tail){
        if(head == null || head.next == null || head.next.next == null) return;

        //it will work for 3 or more nodes

        Node curr = tail.prev;

        while(curr.prev != null){
            if(curr.prev.val == curr.next.val){
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            curr = curr.prev;
        }


    }
}
