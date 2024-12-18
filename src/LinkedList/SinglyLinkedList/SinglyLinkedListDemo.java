package LinkedList.SinglyLinkedList;

public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        System.out.println(sl.isEmpty());
        sl.print();
        sl.insertAtTail(new Node(10));
        sl.print();
        sl.insertAtTail(new Node(20));
        sl.print();
        sl.insertAtHead(new Node(5));
        sl.print();
        sl.deleteAtTail();
        sl.print();
        sl.deleteAtHead();
        sl.print();
        sl.insertAtTail(new Node(30));
        sl.print();
        sl.insertAtHead(new Node(10));
        sl.print();
        sl.insertAtPosition(new Node(40), 2);
        sl.print();
        sl.deleteAtPos(2);
        sl.print();
    }
}
