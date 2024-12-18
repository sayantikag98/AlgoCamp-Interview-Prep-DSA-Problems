package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.print;


//https://www.naukri.com/code360/problems/sort-linked-list-of-0s-1s-2s_1071937
public class SortLinkedList0And1And2 {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,0,1,2,2,0});
//        head = sortList(head);
        head = sortListMoreConciseImplementation(head);
        print(head);
    }

    public static Node sortListMoreConciseImplementation(Node head) {
        //TC = O(n), SC = O(1)

        if(head == null || head.next == null) return head;

        Node c = head,
                dummy1 = new Node(-1), z = dummy1,
                dummy2 = new Node(-1), o = dummy2,
                dummy3 = new Node(-1), t = dummy3;

        while(c != null){
            if(c.val == 0){
                z.next = c;
                z = z.next;
            }
            else if(c.val == 1){
                o.next = c;
                o = o.next;
            }
            else{
                t.next = c;
                t = t.next;
            }
            c = c.next;
        }

        z.next = dummy2.next != null ? dummy2.next : dummy3.next;
        o.next = dummy3.next;
        t.next = null;

        return dummy1.next;
    }

    public static Node sortList(Node head) {
        // Write your code here
        if(head == null || head.next == null) return head;

        Node c = head,
                dummy1 = new Node(-1), z = dummy1,
                dummy2 = new Node(-1), o = dummy2,
                dummy3 = new Node(-1), t = dummy3;

        while(c != null){
            if(c.val == 0){
                z.next = c;
                z = z.next;
            }
            else if(c.val == 1){
                o.next = c;
                o = o.next;
            }
            else{
                t.next = c;
                t = t.next;
            }
            c = c.next;
        }

        Node start = null;
        if(dummy1.next != null){
            start = dummy1.next;
            if(dummy2.next != null){
                z.next = dummy2.next;
                o.next = dummy3.next;
            }
            else{
                z.next = dummy3.next;
            }
        }
        else if(dummy2.next != null){
            start = dummy2.next;
            o.next = dummy3.next;
        }
        else{
            start = dummy3.next;
        }

        t.next = null;

        return start;
    }
}
