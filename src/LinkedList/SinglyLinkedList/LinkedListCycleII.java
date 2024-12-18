package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.DetectAndRemoveLoop.removeLoop;

//https://leetcode.com/problems/linked-list-cycle-ii/description/
public class LinkedListCycleII {
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.insertAtTail(new Node(1));
        ll.insertAtTail(new Node(2));
        ll.insertAtTail(new Node(3));
        ll.insertAtTail(new Node(4));
        ll.insertAtTail(new Node(5));
        ll.insertAtTail(new Node(6));

        Node head = ll.getHead();

        //introducing loop
        head.next.next.next.next.next.next = head;

        Node meeting = detectCycle(head);

        if(meeting == null){
            System.out.println("No cycle detected");
        }
        else{
            System.out.println(meeting.val);
        }

        head = removeLoop(head);

        meeting = detectCycle(head);

        if(meeting == null){
            System.out.println("No cycle detected");
        }
        else{
            System.out.println(meeting.val);
        }


    }

    private static Node detectCycle(Node head) {
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null) return null;

        fast = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
