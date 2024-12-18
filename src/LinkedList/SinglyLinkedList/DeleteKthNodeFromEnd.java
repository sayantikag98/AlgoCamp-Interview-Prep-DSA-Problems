package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class DeleteKthNodeFromEnd {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5});
//        head = deleteKthNodeFromEnd(head, 0);
        head = deleteKthNodeFromEndAnotherApproach(head, 6);
        print(head);
    }

    private static Node deleteKthNodeFromEndAnotherApproach(Node head, int k){
        if(k < 1) return head;
        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node p1 = dummyNode, p2 = p1;
        int diff = 0;
        while(diff<k && p2 != null){
            p2 = p2.next;
            diff++;
        }
        if(p2 == null) return head;
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return dummyNode.next;
    }
    private static Node deleteKthNodeFromEnd(Node head, int k){
        if(head == null) return null;
        Node slow = head, fast = head;
        int count = 1;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        int n = 0;
        if(fast == null){
            n = 2*count - 2;
        }
        else{
            n = 2*count - 1;
        }

        //check if k is [1, n] where n is the total nodes
        if(k < 1 || k > n) return head;

        int kstart = n-k+1;

        //kstart will be from 1 to n only

        Node dummyNode = new Node(-1);
        dummyNode.next = head;

        if(kstart <= count){
            deleteAtPos(dummyNode, kstart);
        }
        else{
            deleteAtPos(slow, kstart - count);
        }

        return dummyNode.next;
    }

    private static void deleteAtPos(Node head, int k){
        Node temp = head;
        while(k-->1){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}
