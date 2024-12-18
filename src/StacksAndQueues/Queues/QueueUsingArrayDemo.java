package StacksAndQueues.Queues;

public class QueueUsingArrayDemo {
    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray();
        System.out.println("is full "+q.isFull());
        System.out.println("is empty "+q.isEmpty());
        q.enqueue(10);
        System.out.println("front "+q.front());
        System.out.println("rear "+q.rear());
        q.enqueue(20);
        q.print();
        System.out.println("front "+q.front());
        System.out.println("rear "+q.rear());
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.print();
        System.out.println("front "+q.front());
        System.out.println("rear "+q.rear());
        System.out.println("dequeue "+q.dequeue());
        q.print();
        System.out.println("front "+q.front());
        System.out.println("rear "+q.rear());
        System.out.println("dequeue "+q.dequeue());
        q.print();
        System.out.println("front "+q.front());
        System.out.println("rear "+q.rear());
    }
}
