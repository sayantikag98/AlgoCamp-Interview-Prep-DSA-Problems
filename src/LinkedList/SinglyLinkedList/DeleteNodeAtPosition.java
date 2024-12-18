package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class DeleteNodeAtPosition {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5});
        head = deleteAtPos(head, 6);
        print(head);
    }
    private static Node deleteAtPos(Node head, int pos){
        if(pos == 0){
            if(head != null) head = head.next;
        }
        else if(pos>0){
            Node temp = head;
            while(pos-->1 && temp != null){
                temp = temp.next;
            }
            if(temp != null && temp.next != null){
                temp.next = temp.next.next;
            }
        }
        return head;
    }
}
