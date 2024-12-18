package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

//https://www.naukri.com/code360/problems/add-one-to-linked-list_920456
public class AddOneToLinkedList {
    public static void main(String[] args) {
        Node head = convert(new int[]{4,2,9});
        head.next.next.next = new Node(-1); //-1 added in the question thats why added here
        head = addOneToListUsingRecursionWithoutReversing1(head);
//        head = addOneToListWithReversing(head);
        print(head);
    }

    public static Node addOneToListUsingRecursionWithoutReversing1(Node linkedListNode) {
        int carry = helper1(linkedListNode);
        if(carry != 0){
            Node temp = new Node(carry);
            temp.next = linkedListNode;
            linkedListNode = temp;
        }
        return linkedListNode;
    }

    private static int helper1(Node f){
        if(f.val == -1){
            return 1;
        }
        int sum = helper1(f.next);
        sum += f.val;

        f.val = sum%10;
        return sum/10;
    }

    public static Node addOneToListUsingRecursionWithoutReversing(Node linkedListNode) {
        //TC = O(n), SC = O(n)
        Node head = helper(linkedListNode);
        if(head.val == 0) return head.next;
        return head;
    }

    private static Node helper(Node f){
        if(f.val == -1){
            Node temp = new Node(1);
            temp.next = new Node(-1);
            return temp;
        }
        Node recHead = helper(f.next);

        int sum = recHead.val;
        sum += f.val;

        recHead.val = sum%10;

        Node temp = new Node(sum/10);
        temp.next = recHead;
        return temp;
    }

    public static Node addOneToListWithReversing(Node linkedListNode) {
        // Write your code here
        Node temp = reverse(linkedListNode), dummy = new Node(-1), c = dummy, l = temp;

        c.next = new Node(-1);
        c = c.next;

        int carry = 1; //initialize it to one instead of zero
        while(l != null){
            if(l.val != -1){
                int sum = l.val + carry;
                c.next = new Node(sum%10);
                carry = sum/10;
                c = c.next;
                if(carry == 0){
                    c.next = l.next;
                    break;
                }
            }
            l = l.next;
        }

        if(carry != 0) c.next = new Node(carry);

        l = reverse(dummy.next);

        return l;
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
