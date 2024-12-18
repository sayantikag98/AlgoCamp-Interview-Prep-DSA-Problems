package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class DeleteNodeInALinkedList {

    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4});
//        deleteNode(head.next.next);
        deleteNodeMoreOptimized(head.next);
        print(head);
    }

    private static void deleteNodeMoreOptimized(Node node) {
        //TC = O(1)
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static void deleteNode(Node node) {
        //TC = O(n)
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

}
