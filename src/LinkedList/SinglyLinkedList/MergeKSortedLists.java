package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.print;

//https://leetcode.com/problems/merge-k-sorted-lists/description/
public class MergeKSortedLists {
    public static void main(String[] args) {
        Node head1 = convert(new int[]{1,2,3});
        Node head2 = convert(new int[]{2,5,5,6});
        Node head3 = convert(new int[]{2,3});
//        Node head = mergeKLists(new Node[]{head1, head2, head3});
        Node head = mergeKListsUsingMergingTwoSortedLists(new Node []{head1, head2, head3});
        print(head);
    }

    private static Node mergeKListsUsingMergingTwoSortedLists(Node[] lists) {

        //*****************repeatedly merging the two sorted list***************************

        //lists.length = k, TC = O(k*(n+m))

        if(lists.length == 0) return null; //MADE MISTAKE NEED TO CHECK THIS
        for(int i = 0; i<lists.length-1; i++){
            lists[i+1] = mergeTwoSortedList(lists[i], lists[i+1]);
        }
        return lists[lists.length-1];
    }

    private static Node mergeTwoSortedList(Node head1, Node head2){

        Node dummy = new Node(-1), p = dummy;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                p.next = head1;
                head1 = head1.next;
            }
            else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }

        //made MISTAKE here 

        if(head1 != null){
            p.next = head1;
        }
        else{
            p.next = head2;
        }

        return dummy.next;
    }
    private static Node mergeKLists(Node[] lists) {
        //compute the min of all head nodes
        Node dummy = new Node(-1), p = dummy;
        int minInd = minValNodeIndex(lists);
        while(minInd != -1){
            p.next = lists[minInd];
            lists[minInd] = lists[minInd].next;
            minInd = minValNodeIndex(lists);
            p = p.next;
        }
        return dummy.next;
    }

    private static int minValNodeIndex(Node[] lists){
        int minValInd = -1;
        for(int i = 0; i<lists.length; i++){
            if(lists[i] != null){
                if(minValInd == -1 || lists[minValInd].val > lists[i].val){
                    minValInd = i;
                }
            }
        }
        return minValInd;
    }
}
