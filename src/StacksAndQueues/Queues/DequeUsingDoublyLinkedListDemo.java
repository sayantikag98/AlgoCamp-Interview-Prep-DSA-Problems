package StacksAndQueues.Queues;

public class DequeUsingDoublyLinkedListDemo {
    public static void main(String[] args) {
        DequeUsingDoublyLinkedList<Integer> d = new DequeUsingDoublyLinkedList<>();
        d.print();
        d.offerFirst(10);
        d.offerFirst(5);
        d.offerLast(20);
        d.offerLast(25);
        d.print();
        System.out.println(d.popFirst());
        d.print();
        System.out.println(d.popLast());
        d.print();
        System.out.println(d.getFirst());
        System.out.println(d.getLast());
        System.out.println(d.isFull());
        System.out.println(d.isEmpty());
        System.out.println(d.size());
    }
}
