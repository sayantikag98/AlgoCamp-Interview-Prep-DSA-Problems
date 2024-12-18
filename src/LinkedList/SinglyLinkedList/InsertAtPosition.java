package LinkedList.SinglyLinkedList;
import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.*;

public class InsertAtPosition {

    public static void main(String[] args) {
        Node head = convert(new int[]{2,3,4});
        head = insertAtPos(head, 1, -4);
        print(head);
    }

    private static Node insertAtPos(Node head, int val, int pos){
        Node newNode = new Node(val);
        if(pos == 0){
            newNode.next = head;
            head = newNode;
        }
        else if(pos > 0){
            Node temp = head;
            int currPos = 0;
            while(currPos < pos-1 && temp != null){
                temp = temp.next;
                currPos++;
            }
            if(temp != null){
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        return head;
    }
}
