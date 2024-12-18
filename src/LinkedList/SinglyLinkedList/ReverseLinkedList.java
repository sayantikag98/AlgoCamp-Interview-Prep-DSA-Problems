package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5});
//        head = reverse(head);
//        head = reverse(head, null);
        head = reverseRecursive(head);
        print(head);
        reverseTraversal(head);
    }

    private static Node reverseRecursive(Node head){
        if(head == null || head.next == null) return head;
        Node new_head = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }
    private static Node reverse(Node head){
        Node temp = head, prev = null;
        while(temp != null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    private static Node reverse(Node head, Node prev){
        if(head == null) return prev;
        Node next = head.next;
        head.next = prev;
        return reverse(next, head);
    }

    private static void reverseTraversal(Node head){
        if(head == null) return;
        reverseTraversal(head.next);
        System.out.print(head.val+" -> ");
    }
}
