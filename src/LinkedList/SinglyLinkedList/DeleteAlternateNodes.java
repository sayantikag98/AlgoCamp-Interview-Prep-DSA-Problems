package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class DeleteAlternateNodes  {
    public static void main(String[] args) {
        Node head = convert(new int[] {1,2});
        head = deleteAlternateNodes(head);
        print(head);
    }
    private static Node deleteAlternateNodes(Node head){
        Node temp = head;
        while(temp != null && temp.next != null){
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return head;
    }
}
