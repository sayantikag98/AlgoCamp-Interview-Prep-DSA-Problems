package LinkedList.SinglyLinkedList;

public class GenericSinglyLinkedListDemo {
    public static void main(String[] args) {
        GenericSinglyLinkedList<Integer> gsl = new GenericSinglyLinkedList<>();
        System.out.println(gsl.isEmpty());
        gsl.print();
        gsl.insertAtTail(10);
        gsl.print();
        gsl.insertAtTail(20);
        gsl.print();
        gsl.insertAtHead(5);
        gsl.print();
        gsl.deleteAtTail();
        gsl.print();
        gsl.deleteAtHead();
        gsl.print();
        gsl.insertAtTail(30);
        gsl.print();
        gsl.insertAtHead(10);
        gsl.print();
        gsl.insertAtPosition(40, 2);
        gsl.print();
        gsl.deleteAtPos(2);
        gsl.print();

        GenericSinglyLinkedList<String> gsl1 = new GenericSinglyLinkedList<>();
        System.out.println(gsl1.isEmpty());
        gsl1.print();
        gsl1.insertAtTail("abc");
        gsl1.print();
        gsl1.insertAtTail("def");
        gsl1.print();
        gsl1.insertAtHead("ghi");
        gsl1.print();
        gsl1.deleteAtTail();
        gsl1.print();
        gsl1.deleteAtHead();
        gsl1.print();
        gsl1.insertAtTail("jkl");
        gsl1.print();
        gsl1.insertAtHead("mno");
        gsl1.print();
        gsl1.insertAtPosition("prq", 2);
        gsl1.print();
        gsl1.deleteAtPos(2);
        gsl1.print();
    }
}
