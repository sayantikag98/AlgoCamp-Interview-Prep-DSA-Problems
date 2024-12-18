package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;
public class DeleteNodeBasedOnValue {
    public static void main(String[] args) {
        Node head = convert(new int[]{1});
        head = deleteVal(head, 2);
        print(head);
    }
    private static Node deleteVal(Node head, int val){
        if(head == null) return null;
        if(head.val == val){
            head = head.next;
        }
        else{
            Node temp = head;
            while(temp.next != null && temp.next.val != val){
                temp = temp.next;
            }
            if(temp.next != null){
                temp.next = temp.next.next;
            }
        }
        return head;
    }
}
