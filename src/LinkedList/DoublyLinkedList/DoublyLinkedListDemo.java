package LinkedList.DoublyLinkedList;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.print();
        System.out.println(dll.getHead());
        System.out.println(dll.getTail());

        dll.insertAtHead(4);
        System.out.println(dll.getHead());
        System.out.println(dll.getTail());
        System.out.println(dll.getHead().val);
        System.out.println(dll.getTail().val);
        dll.print();

        dll.insertAtHead(3);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtHead(2);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtTail(5);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtTail(6);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtPos(0, 0);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtPos(0, 1);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtPos(10, 3);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtPos(20, 7);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtPos(20, 9);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.insertAtPos(200, 11);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.deleteAtHead();
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.deleteAtTail();
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.deleteAVal(6);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.deleteAVal(60);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.deleteAVal(4);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();


        dll.deleteAtPos(3);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.deleteAtPos(4);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();

        dll.deleteAtPos(4);
        System.out.println("head " + dll.getHead());
        System.out.println("tail " + dll.getTail());
        System.out.println("head " + dll.getHead().val);
        System.out.println("tail " + dll.getTail().val);
        dll.print();


    }
}
