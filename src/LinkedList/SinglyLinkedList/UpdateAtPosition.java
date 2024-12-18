package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class UpdateAtPosition {
    public static void main(String[] args) {
        Node head = convert(new int[]{});
        head = updateAtPos(head, 100, 6);
        print(head);
    }

    private static Node updateAtPos(Node head, int val, int pos){
        if(pos >= 0){
            //pos => 0 based
            Node temp = head;
            while(pos-->0 && temp != null){
                temp = temp.next;
            }
            if(temp != null){
                temp.val = val;
            }
        }
        return head;
    }
}
