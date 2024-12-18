package LinkedList.SinglyLinkedList;

public class ConvertArrayToLinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = convert(arr);
        print(head);
    }

    static Node convert(int[] arr){
        int n = arr.length;
        if(n == 0) return null;
        Node head = new Node(arr[0]), prev = head;
        for(int i = 1; i<n; i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    static void print(Node head){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
