package StacksAndQueues.Stacks;

class Node<T>{
    T val;
    Node<T> next;

    Node(T val){
        this.val = val;
        this.next = null;
    }
}

public class StackUsingLinkedList<T>{
    private Node<T> head;
    private int size;
    private final int maxCapacity;

    StackUsingLinkedList(int maxCapacity){
        this.head = null;
        this.size = 0;
        this.maxCapacity = maxCapacity;
    }

    StackUsingLinkedList(){
        this(5);
    }

    void push(T val){
        if(this.size() == this.maxCapacity){
            System.out.println("Stack Overflow");
            return;
        }
        Node<T> newNode = new Node<>(val);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    T pop(){
        if(this.head == null){
            System.out.println("Stack Underflow");
            return null;
        }
        Node<T> popElement = this.head;
        this.head = this.head.next;
        this.size--;
        popElement.next = null;
        return popElement.val;
    }

    T peek(){
        if(this.head == null){
            System.out.println("Stack Underflow");
            return null;
        }
        return this.head.val;
    }

    int size(){
        return this.size;
    }

    boolean isEmpty(){
        return this.head == null;
    }

    boolean isFull(){
        return this.size == this.maxCapacity;
    }

    void print(){
        if(this.head == null){
            System.out.println("Stack is empty");
        }
        else{
            Node<T> temp = this.head;
            while(temp != null){
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

}
