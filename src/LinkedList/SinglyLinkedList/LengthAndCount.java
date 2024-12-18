package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class LengthAndCount {
    public static void main(String[] args) {
        Node head = convert(new int[]{1,2,3,4});
        System.out.println(findLen(head));
        System.out.println(isPresent(head, 3));
        System.out.println(findLenRecursive(head));
        System.out.println(isPresentRecursive(head, 7));
    }

    private static int findLenRecursive(Node head){
        if(head == null) return 0;
        int cnt = findLenRecursive(head.next);
        return cnt+1;
    }

    private static int findLen(Node head){
        Node temp = head;
        int counter = 0;
        while(temp != null){
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    private static boolean isPresent(Node head, int val){
        Node temp = head;
        while(temp != null){
            if(temp.val == val) return true;
            temp = temp.next;
        }
        return false;
    }

    private static boolean isPresentRecursive(Node head, int val){
        if(head == null) return false;
        return head.val == val || isPresentRecursive(head.next, val);
    }
}
