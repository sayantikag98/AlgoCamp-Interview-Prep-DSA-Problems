package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.print;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5,6,7,8});
        head = reverseKGroup(head, 3);
        print(head);
    }
    private static Node reverseKGroup(Node head, int k) {
        Node pe = null, ns = head, start = ns, end = start, temp = head;
        head = null;
        while(end != null){
            start = ns;
            end = start;
            int count = 1;
            while(count<k && end != null){
                end = end.next;
                count++;
            }
            if(end != null){
                ns = end.next;
                Node nh = reverseInRange(start, end);
                if(pe != null){
                    pe.next = nh;
                }
                pe = start;
                if(head == null){
                    head = nh;
                }
            }
            else{
                if(pe != null){
                    pe.next = ns;
                }
                else{
                    head = temp;
                }
            }
        }
        return head;
    }

    private static Node reverseInRange(Node start, Node end){
        Node temp = start, prev = null;
        while(prev != end){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
