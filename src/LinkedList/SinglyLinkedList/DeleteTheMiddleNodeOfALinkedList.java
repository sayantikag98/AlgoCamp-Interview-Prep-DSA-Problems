package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.print;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3});
        head = deleteMiddle(head);
        print(head);
    }
    private static Node deleteMiddle(Node head) {
        if(head.next == null) return null;
        Node slow = null, fast = head;

        while(fast != null && fast.next != null){
            if(slow == null) slow = head;
            else slow = slow.next;

            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
