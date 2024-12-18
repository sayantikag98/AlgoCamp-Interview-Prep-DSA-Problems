package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class SortList {
    public static void main(String[] args) {
        int[] nums = {3,1,3,5,2,6};
        Node head = convert(nums);
        head = sortListUsingBubbleSort(head);
        print(head);

        int[] nums1 = {-1,5,2,4,2,1,-1};
        Node head1 = convert(nums1);
        head1 = helper(head1);
        print(head1);
    }

    private static Node helper(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //*************** SPITTING THE LINKED LIST IS IMP HERE ***************************
        prev.next = null;
        //********************************************************************************



        Node head1 = helper(head);
        Node head2 = helper(slow);
        return merge(head1, head2);
    }

    private static Node merge(Node head1, Node head2){
        Node dummy = new Node(-1), curr = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                curr.next = head1;
                head1 = head1.next;
            }
            else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        //while not required because its a sorted linked list
        if(head1 != null){
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;
        }
        if(head2 != null){
            curr.next = head2;
            head2 = head2.next;
            curr = curr.next;
        }
        return dummy.next;
    }


    private static Node sortListUsingBubbleSort(Node head) {
        Node prev = null, dummy = new Node(-1);
        dummy.next = head;
        Node temp = dummy;
        while(temp.next != prev){
            while(temp.next.next != prev){
                if(temp.next.val>temp.next.next.val){
                    Node curr = temp.next;
                    temp.next = temp.next.next;
                    curr.next = curr.next.next;
                    temp.next.next = curr;
                }
                temp = temp.next;
            }
            prev = temp.next;
            temp = dummy;
        }
        return dummy.next;
    }
}
