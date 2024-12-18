package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

//https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5});
        reorderList(head);
        print(head);
    }
    private static void reorderList(Node head) {
        //TC = O(n)
        if(head.next == null || head.next.next == null) return;

        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node nh = null;
        if(fast == null){
            nh = reverse(slow);
        }
        else{
            nh = reverse(slow.next);
            slow.next = null;
        }

        Node c = head;

        //v.imp -> this while loop should run till c != null and not c.next != null
//        while(c != null){
//            Node n = c.next;
//            //v.imp => this if check is important otherwise it will form a cycle in case of even length linked list where c = nh
//            if(c != nh) c.next = nh;
//            nh = n;
//            c = c.next;
//        }

        //******** while can also be written like this ****************************

        while(c != nh){
            Node n = c.next;
            c.next = nh;
            nh = n;
            c = c.next;
        }
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
