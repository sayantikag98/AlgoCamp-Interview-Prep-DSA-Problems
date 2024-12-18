package StacksAndQueues.Queues;

public class QueueUsingLinkedList <T>{
    private Node<T> head;
    private Node<T> tail;
    private final int capacity;
    private int size;

    private static class Node<T>{
        T val;
        Node<T> next;

        Node(T val){
            this.val = val;
            this.next = null;
        }
    }

    QueueUsingLinkedList(int capacity){
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
        this.size = 0;
    }

    QueueUsingLinkedList(){
        this(10);
    }

    void enqueue(T val){
        //TC = O(1)
        if(this.size == this.capacity){
            System.out.println("Queue Overflow");
            return;
        }
        Node<T> newNode = new Node<>(val);
        if(this.head == null){
            this.head = newNode;
        }
        else{
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.size++;
    }

    T dequeue(){
        //TC = O(1)
        if(this.head == null){
            System.out.println("Queue Underflow");
            return null;
        }
        Node<T> delNode = this.head;
        if(this.head.next == null){
            this.tail = null;
        }
        this.head = this.head.next;
        this.size--;
        return delNode.val;
    }

    boolean isFull(){
        return this.size == this.capacity;
    }

    boolean isEmpty(){
        return this.head == null;
    }

    int size(){
        return this.size;
    }

    T front(){
        if(this.head == null){
            System.out.println("Queue Underflow");
            return null;
        }
        return this.head.val;
    }

    T rear(){
        if(this.head == null){
            System.out.println("Queue Underflow");
            return null;
        }
        return this.tail.val;
    }

    void print(){
        Node<T> temp = this.head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}


