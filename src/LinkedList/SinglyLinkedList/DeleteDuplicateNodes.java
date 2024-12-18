package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class DeleteDuplicateNodes {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,2,2,2,2,3,4,4,4,4,5});
        head = deleteDuplicates(head);
        print(head);
    }

    private static Node deleteDuplicates(Node head){
        Node temp = head, prev = head;
        while(temp != null){
            while(temp != null && prev.val == temp.val){
                temp = temp.next;
            }
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
}
