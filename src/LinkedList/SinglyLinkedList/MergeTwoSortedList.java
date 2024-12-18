package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.print;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList {
    public static void main(String[] args) {
        Node head1 = convert(new int[]{1,2,3});
        Node head2 = convert(new int[]{1,3,4});
//        Node head = mergeTwoLists1(head1, head2);
        Node head = mergeTwoListsUsingRecursion(head1, head2);
        print(head);
    }

    private static Node mergeTwoListsUsingRecursion(Node list1, Node list2) {
        Node dummy = new Node(-1);
        return helper(list1, list2, dummy).next;
    }

    private static Node helper(Node l1, Node l2, Node p){
        if(l1 == null){
            p.next = l2;
        }
        else{
            p.next = l1;
        }

        if(l1 != null && l2 != null){
            if(l1.val <= l2.val){
//                p.next = l1;
                helper(l1.next, l2, p.next);
            }
            else{
                p.next = l2;
                helper(l1, l2.next, p.next);
            }
        }

        return p;
    }

    private static Node mergeTwoLists1(Node list1, Node list2) {
        //using dummy node
        //this implementation is very similar to merge two sorted array implementation
        Node dummyNode = new Node(-1), p = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val<=list2.val){
                p.next = list1;
                list1 = list1.next;
            }
            else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 != null){
            p.next = list1;
        }

        if(list2 != null){
            p.next = list2;
        }

        return dummyNode.next;
    }
    
    private static Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        Node head = null;
        boolean isFirst = list1.val<=list2.val;
        while(list1 != null && list2 != null){
            if(isFirst){
                Node next = list1.next;
                if(next == null || next.val > list2.val){
                    list1.next = list2;
                    isFirst = false;
                }
                if(head == null){
                    head = list1;
                }
                list1 = next;
            }
            else{
                Node next = list2.next;
                if(next == null || next.val > list1.val){
                    list2.next = list1;
                    isFirst = true;
                }
                if(head == null){
                    head = list2;
                }
                list2 = next;
            }
        }
        return head;
    }
}
