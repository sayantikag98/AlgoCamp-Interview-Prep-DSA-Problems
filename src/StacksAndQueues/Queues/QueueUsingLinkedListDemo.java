package StacksAndQueues.Queues;

public class QueueUsingLinkedListDemo {
    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> q = new QueueUsingLinkedList<>();
        System.out.println(q.isFull());
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        q.print();
        q.enqueue(10);
        q.enqueue(20);
        q.print();
        System.out.println(q.dequeue());
        q.print();
        q.enqueue(30);
        System.out.println(q.front());
        System.out.println(q.rear());
        q.print();
    }
}
