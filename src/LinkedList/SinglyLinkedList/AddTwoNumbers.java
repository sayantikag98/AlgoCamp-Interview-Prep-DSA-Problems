package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.print;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public static void main(String[] args) {
        Node head1 = convert(new int[]{9,9,9,9});
        Node head2 = convert(new int[]{9,9,9});
        print(addTwoNumbers(head1, head2));
    }
    private static Node addTwoNumbers(Node l1, Node l2) {
        Node c1 = l1, c2 = l2, dummy = new Node(-1), c = dummy;
        int carry = 0;
        while(c1 != null || c2 != null){
            int sum = carry;
            if(c1 != null) sum += c1.val;
            if(c2 != null) sum += c2.val;
            c.next = new Node(sum%10);
            carry = sum/10;
            c = c.next;
            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;
        }
        if(carry != 0) c.next = new Node(carry);
        return dummy.next;
    }
}
