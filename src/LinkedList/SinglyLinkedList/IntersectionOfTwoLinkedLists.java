package LinkedList.SinglyLinkedList;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        SinglyLinkedList ll1 = new SinglyLinkedList();
        ll1.insertAtTail(new Node (1));
        ll1.insertAtTail(new Node (2));
        ll1.insertAtTail(new Node (3));
        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll2.insertAtTail(new Node (7));
        ll2.insertAtTail(new Node (8));
        Node newNode = new Node(4);
        ll1.insertAtTail(newNode);
        ll2.insertAtTail(newNode);
        newNode.next = new Node(5);
        ll1.print();
        ll2.print();

        Node head1 = ll1.getHead(), head2 = ll2.getHead();
        Node intersection = getIntersectionNode(head1, head2);
        System.out.println(intersection == null ? null : intersection.val);
        intersection = getIntersectionNode1(head1, head2);
        System.out.println(intersection == null ? null : intersection.val);
    }
    private static Node getIntersectionNode(Node headA, Node headB) {
        Node p1 = headA, p2 = headB;
        while(p1 != null && p2 != null){
            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null && p2 == null) return null;
        if(p1 == null){
            p1 = headB;
            while(p2 != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            p2 = headA;
        }
        else{
            p2 = headA;
            while(p1 != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            p1 = headB;
        }

        while(p1 != null && p2 != null){
            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    private static Node getIntersectionNode1(Node headA, Node headB) {
        Node p1 = headA, p2 = headB;
        while(p1 != null || p2 != null){
            //linked list 1 is shorter
            if(p1 == null) p1 = headB;

            //linked list 2 is shorter
            if(p2 == null) p2 = headA;

            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
