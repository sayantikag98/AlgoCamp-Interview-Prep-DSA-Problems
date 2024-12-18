package LinkedList.DoublyLinkedList;
import java.util.*;

import static LinkedList.DoublyLinkedList.ConvertArrayToDLL.convert;

public class FindTargetSum {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtTail(2);
        dll.insertAtTail(5);
        dll.insertAtTail(5);
        dll.insertAtTail(8);
        dll.insertAtTail(10);
        Node head = dll.getHead(), tail = dll.getTail();
        List<Integer> ans = findTargetSum(head, tail, 11);
        System.out.println(ans);
    }

    private static List<Integer> findTargetSum(Node left, Node right, int target){
        //left and right pointer crossing each other will not occur because any one of the pointer is moving at once
        //we have to return distinct nodes so left and meeting each other should be our stopping criterion
        while(left != right){
            int sum = left.val + right.val;
            if(sum == target){
                return List.of(left.val, right.val);
            }
            else if(sum > target){
                right = right.prev;
            }
            else{
                left = left.next;
            }
        }

        return List.of(-1, -1);
    }
}
