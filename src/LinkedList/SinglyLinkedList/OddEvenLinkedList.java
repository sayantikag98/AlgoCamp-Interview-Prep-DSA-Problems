package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5,6});
        head = oddEvenList(head);
        print(head);
    }
    private static Node oddEvenList(Node head) {
        //TC = O(n)
        if(head == null){
            return head;
        }

        Node eh = head.next, ce = eh, co = head;

        while(ce != null && ce.next != null){
            co.next = co.next.next;
            co = co.next;
            ce.next = ce.next.next;
            ce = ce.next;
        }

        co.next = eh;
        return head;
    }
}
