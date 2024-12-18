package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5});
//        head = swapPairsRecursive(head);
        head = swapPairs(head);
        print(head);
    }
    private static Node swapPairs(Node head) {
        //TC = O(n)
        if(head == null || head.next == null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node c = dummy;
        //loop c till last or second last
        while(c.next != null && c.next.next != null){
            Node n = c.next;
            c.next = n.next;
            n.next = n.next.next;
            c.next.next = n;
            c = c.next.next;
        }
        return dummy.next;
    }

    private static Node swapPairsRecursive(Node head) {
        //TC = O(n)
        if(head == null || head.next == null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node c = dummy;
        helper(c);
        return dummy.next;
    }


    private static void helper(Node c){
        if(c.next == null || c.next.next == null) return;
        Node n = c.next;
        c.next = n.next;
        n.next = n.next.next;
        c.next.next = n;
        helper(c.next.next);
    }
}
