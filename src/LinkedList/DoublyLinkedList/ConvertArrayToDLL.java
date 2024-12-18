package LinkedList.DoublyLinkedList;

public class ConvertArrayToDLL {

    public static void main(String[] args) {
        Node head = convert(new int[]{1,3,5,6,8});
        print(head);
        reversePrint(head);
    }

    static Node convert(int[] arr){
        if(arr.length == 0) return null;
        Node head = null, tail = null;

        for(int ele : arr){
            Node newNode = new Node(ele);
            if(head == null){
                head = newNode;
                tail = head;
            }
            else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;
            }
        }

        return head;
    }

    static void print(Node temp){
        while(temp != null){
            System.out.print(temp.val + " <=> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static void reversePrint(Node temp){
        while(temp != null && temp.next != null){
            temp = temp.next;
        }
        while(temp != null){
            System.out.print(temp.val+" <=> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}
