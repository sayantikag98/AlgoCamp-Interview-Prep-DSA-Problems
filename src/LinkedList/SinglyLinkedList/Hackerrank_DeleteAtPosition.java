package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class Hackerrank_DeleteAtPosition {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4});
        //position will start from 0
//        head = deleteNode(head, 2);
        head = deleteNodeAnotherApproach(head, 0);
        print(head);
    }
    private static Node deleteNode(Node llist, int position) {
        // Write your code here
        if(position == 0){
            llist = llist.next;
        }
        else{
            Node temp = llist;
            while(--position>0){
                if(temp != null){
                    temp = temp.next;
                }
                else{
                    break;
                }
            }
            if(temp != null && temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return llist;
    }

    public static Node deleteNodeAnotherApproach(Node llist, int position) {
        // Write your code here
        int cnt = 0;
        Node temp = llist, prev = null;
        while(cnt < position){
            if(temp == null) break;
            prev = temp;
            temp = temp.next;
            cnt++;
        }
        if(prev == null){
            llist = llist.next;
        }
        else if(temp != null){
            prev.next = temp.next;
        }
        return llist;
    }

}
