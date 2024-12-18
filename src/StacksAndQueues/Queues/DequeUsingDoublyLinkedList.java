package StacksAndQueues.Queues;

public class DequeUsingDoublyLinkedList<T> {
    private static class Node<T>{
        T val;
        Node<T> prev;
        Node<T> next;

        Node(T val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private final int capacity;
    private int size;

    DequeUsingDoublyLinkedList(int capacity){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }

    DequeUsingDoublyLinkedList(){
        this(10);
    }

    boolean offerFirst(T val){
        if(this.size == this.capacity) return false;
        Node<T> newNode = new Node<>(val);
        if(this.head == null){
            this.tail = newNode;
        }
        else{
            newNode.next = this.head;
            this.head.prev = newNode;
        }
        this.head = newNode;
        this.size++;
        return true;
    }

    boolean offerLast(T val){
        if(this.size == this.capacity) return false;
        Node<T> newNode = new Node<>(val);
        if(this.head == null){
            this.head = newNode;
        }
        else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        this.size++;
        return true;
    }

    T popFirst(){
        if(this.head == null) return null;
        Node<T> delNode = this.head;
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
        }
        else{
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return delNode.val;
    }

    T popLast(){
        if(this.head == null) return null;
        Node<T> delNode = this.tail;
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
        }
        else{
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return delNode.val;
    }

    T getFirst(){
        if(this.head == null) return null;
        return this.head.val;
    }

    T getLast(){
        if(this.head == null) return null;
        return this.tail.val;
    }

    boolean isEmpty(){
        return this.head == null;
    }

    boolean isFull(){
        return this.size == this.capacity;
    }

    int size(){
        return this.size;
    }

    void print(){
        Node<T> temp = this.head;
        while(temp != null){
            System.out.print(temp.val + " <=> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
