package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Node middle = middleNode(convert(new int[]{1,2,3,4}));
        System.out.println(middle.val);
    }
    private static Node middleNode(Node head) {
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
