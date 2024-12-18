package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;
//https://leetcode.com/problems/palindrome-linked-list/
/*
    The Java programming language does not pass objects by reference;
    it passes object references by value. Because two copies of the
    same reference refer to the same actual object, changes made through
    one reference variable are visible through the other. There is exactly
    one parameter passing mode — pass by value — and that helps keep things simple.
*/
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,2,1});
        System.out.println(isPalindrome(head));
    }
    private static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;

        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // print(head);
        Node reverseHead = reverse(fast == null ? slow : slow.next);
        // print(head);
        fast = head;
        slow = reverseHead;
        boolean isPalindrome = true;
        while(slow != null){
            if(slow.val != fast.val){
                isPalindrome = false;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        reverse(reverseHead);
        // print(head);
        return isPalindrome;
    }

    private static Node reverse(Node temp){
        Node prev = null;
        while(temp != null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
