package LinkedList.DoublyLinkedList;
import java.util.*;

import static LinkedList.DoublyLinkedList.ConvertArrayToDLL.convert;

//https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/0
public class FindPairsWithGivenSumInDoublyLinkedList {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5});
        ArrayList<ArrayList<Integer>> lans = findPairsWithGivenSum(6, head);
        System.out.println(lans);
    }
    private static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node last = head;
        while(last.next != null){
            last = last.next;
        }

        ArrayList<ArrayList<Integer>> lans = new ArrayList<>();

        Node first = head;

        //here when we get a pair then we move both the pointers so they can cross each other
        while(first != last && first.prev != last){
            int sum = first.val + last.val;
            if(sum == target){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(first.val);
                ans.add(last.val);
                lans.add(ans);
                first = first.next;
                last = last.prev;
            }
            else if(sum > target){
                last = last.prev;
            }
            else{
                first = first.next;
            }
        }

        return lans;

    }
}
