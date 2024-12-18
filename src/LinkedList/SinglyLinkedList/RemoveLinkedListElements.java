package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Node head = convert(new int[] {1,2,6,6,6,6,3,3,6,6});
        head = removeElements2(head, 6);
        print(head);
    }

    private static Node removeElements(Node head, int val) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr = dummy;
        while(curr != null && curr.next != null){
            while(curr.next != null && curr.next.val == val){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    private static Node removeElements1(Node head, int val) {
        Node dummy = new Node(-1), curr = dummy;
        dummy.next = head;
        while(curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }
            else curr = curr.next;
        }
        return dummy.next;
    }

    private static Node removeElements2(Node head, int val){
        Node dummy = new Node(-1), c = dummy;
        dummy.next = head;
        helper(c, val);
        return dummy.next;
    }

    private static void helper(Node curr, int val){
        if(curr.next == null) return;
        if(curr.next.val == val){
            curr.next = curr.next.next;
            helper(curr, val);
        }
        else{
            helper(curr.next, val);
        }
    }
}
