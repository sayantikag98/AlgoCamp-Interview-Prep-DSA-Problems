package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,1,2,2,3,3,3});
        head = deleteDuplicates(head);
        print(head);
    }
    private static Node deleteDuplicates(Node head) {
        if(head == null || head.next == null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node temp = dummy;
        while(temp != null){
            Node curr = temp.next;
            while(curr != null && curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if(curr == temp.next)
                temp = temp.next;
            else{
                temp.next = curr.next;
            }
        }
        return dummy.next;
    }
}
