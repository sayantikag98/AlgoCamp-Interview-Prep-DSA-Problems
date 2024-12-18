package LinkedList.DoublyLinkedList;

import static LinkedList.DoublyLinkedList.ConvertArrayToDLL.*;

//https://www.naukri.com/code360/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461
public class DeleteAllOccurrencesOfAGivenKeyInADoublyLinkedList {
    public static void main(String[] args) {
        Node head = convert(new int[]{10,10,2,3,10,10});
        head = deleteAllOccurrences(head, 10);
        print(head);
    }

    private static Node deleteAllOccurrences(Node head, int k) {
        // Write your code here.
        Node curr = head;
        while(curr != null){
            if(curr.val == k){
                if(curr == head){
                    head = head.next;
                }
                else{
                    curr.prev.next = curr.next;
                    if(curr.next != null) curr.next.prev = curr.prev;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
