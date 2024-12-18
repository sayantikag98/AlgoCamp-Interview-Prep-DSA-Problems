package LinkedList.DoublyLinkedList;

import static LinkedList.DoublyLinkedList.ConvertArrayToDLL.*;

//https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/0

public class RemoveDuplicatesFromASortedDoublyLinkedList {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,1,1,2,2,3,3,3});
        head = removeDuplicates(head);
        print(head);
    }
    static Node removeDuplicates(Node head){
        // Code Here.
        Node temp = head;
        while(temp != null){
            Node curr = temp.next;
            while(curr != null && temp.val == curr.val){
                curr = curr.next;
            }
            temp.next = curr;
            if(curr != null) curr.prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
