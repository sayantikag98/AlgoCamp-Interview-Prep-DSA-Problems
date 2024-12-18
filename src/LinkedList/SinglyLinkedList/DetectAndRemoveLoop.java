package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ConvertArrayToLinkedList.print;

public class DetectAndRemoveLoop {
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


        head = removeLoop(head);

        print(head);


    }
    static Node removeLoop(Node head) {
        // Write your code here.


        //detecting cycle
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null) return head;


//**************  V IMP **************************
//edge case when slow and fast are meeting at head (cycle starting from head)
//************************************************

        //removing cycle

        if(slow != head){

            //when slow & fast are meeting at head then while loop will not execute and slow.next i.e. head.next = null so this will be wrong
            fast = head;


            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }


        }
        else{
            while(slow.next != head){
                slow = slow.next;
            }
        }

        slow.next = null;


        return head;

    }
}
