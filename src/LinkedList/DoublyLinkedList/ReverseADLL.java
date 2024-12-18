package LinkedList.DoublyLinkedList;
import static LinkedList.DoublyLinkedList.ConvertArrayToDLL.*;

//https://leetcode.com/problems/remove-linked-list-elements/description/
public class ReverseADLL {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4,5});
        print(head);
//        head = reverse(head);
//        head = reverse1(head);
        head = reverseRecursive(head, null);
        print(head);
    }
    private static Node reverse(Node llist) {
        // Write your code here
        Node temp = null;
        while(llist != null){
            llist.prev = llist.next;
            llist.next = temp;
            temp = llist;
            llist = llist.prev;
        }
        return temp;
    }

    private static Node reverse1(Node temp){
        if(temp == null) return null;
        while(temp.prev != null){
            Node next = temp.next;
            temp.next = temp.prev;
            temp.prev = next;
            temp = next;
        }
        return temp;
    }

    private static Node reverseRecursive(Node llist, Node temp) {
        if(llist == null) return temp;
        llist.prev = llist.next;
        llist.next = temp;
        return reverseRecursive(llist.prev, llist);
    }


}
