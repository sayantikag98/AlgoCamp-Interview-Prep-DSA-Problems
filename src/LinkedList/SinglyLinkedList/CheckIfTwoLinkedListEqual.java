package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.convert;

public class CheckIfTwoLinkedListEqual {
    public static void main(String[] args) {
        Node head1 = convert(new int[]{1,2,3});
        Node head2 = convert(new int[]{1,2});
        System.out.println(isEqual(head1, head2));
    }
    private static boolean isEqual(Node head1, Node head2){
        Node temp1 = head1, temp2 = head2;
        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1 == null && temp2 == null;
    }
}
