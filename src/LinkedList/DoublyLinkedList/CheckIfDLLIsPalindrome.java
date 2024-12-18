package LinkedList.DoublyLinkedList;

import static LinkedList.DoublyLinkedList.ConvertArrayToDLL.*;

public class CheckIfDLLIsPalindrome {

    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,2,1});
        System.out.println(isPalindrome(head));
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtTail(1);
        dll.insertAtTail(3);
//        dll.insertAtTail(3);
        dll.insertAtTail(2);
        dll.insertAtTail(1);
        System.out.println(isPalindrome(dll.getHead(), dll.getTail()));
    }
    private static boolean isPalindrome(Node head){
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }
        Node nh = null;
        while(slow != null){
            slow.prev = slow.next;
            slow.next = nh;
            nh = slow;
            slow = slow.prev;
        }
        fast = head;
        while(nh != null){
            if(fast.val != nh.val) return false;
            fast = fast.next;
            nh = nh.next;
        }
        return true;
    }

    private static boolean isPalindrome(Node head, Node tail){
        while(head != tail){
            if(head.val != tail.val) return false;
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }
}
