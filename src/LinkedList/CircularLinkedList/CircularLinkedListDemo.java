package LinkedList.CircularLinkedList;

import LinkedList.DoublyLinkedList.DoublyLinkedList;

public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.print();
        

        cll.insertAtHead(4);
        
        cll.print();

        cll.insertAtHead(3);
        
        cll.print();

        cll.insertAtHead(2);
        
        cll.print();

        cll.insertAtTail(5);
        
        cll.print();

        cll.insertAtTail(6);
        
        cll.print();

        cll.insertAtPos(0, 0);
        
        cll.print();

        cll.insertAtPos(0, 1);
        
        cll.print();

        cll.insertAtPos(10, 3);
        
        cll.print();

        cll.insertAtPos(20, 7);
        
        cll.print();

        cll.insertAtPos(20, 9);
        
        cll.print();

        cll.insertAtPos(200, 11);
        
        cll.print();

        cll.deleteAtHead();
       
        cll.print();

        cll.deleteAtTail();
        
        cll.print();

        cll.deleteAVal(6);
        
        cll.print();

        cll.deleteAVal(60);
        
        cll.print();

        cll.deleteAVal(4);
        
        cll.print();


        cll.deleteAtPos(3);
        
        cll.print();

        cll.deleteAtPos(4);
        
        cll.print();

        cll.deleteAtPos(4);
        
        cll.print();
    }
}
