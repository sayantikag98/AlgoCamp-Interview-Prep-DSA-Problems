package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

//https://leetcode.com/problems/rotate-list/
public class RotateList {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5,6});
//        head = rotateRight(head, 3);
        head = rotateRight1(head, 3);
        print(head);
    }

    private static Node rotateRight1(Node head, int k) {
        //TC = O(n+n-k)
        if(head == null || head.next == null) return head;
        int n = 1;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        k%=n;

        if(k < 0){
            k += n;
        }

        // k now lies in the range of [0, n-1]
        if(k == 0) return head;


        int count = 1;
        Node temp1 = head;

        while(count < n-k){
            temp1 = temp1.next;
            count++;
        }


        temp.next = head;
        head = temp1.next;
        temp1.next = null;

        return head;

    }
    private static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null) return head;
        Node slow = head, fast = head;
        int count = 1;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        int n = 0;

        if(fast == null){
            n = 2*count-2;
        }
        else{
            n = 2*count-1;
        }

        k%=n;

        if(k < 0){
            k += n;
        }

        // k now lies in the range of [0, n-1]
        if(k == 0) return head;
        count = 1;
        fast = head; slow = head;

        while(fast.next != null){
            if(count < n-k) {
                slow = slow.next;
                count++;
            }
            fast = fast.next;
        }


        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
