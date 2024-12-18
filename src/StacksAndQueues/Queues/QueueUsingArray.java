package StacksAndQueues.Queues;

public class QueueUsingArray {
    private final int[] arr;
    private int front, rear;
    private final int capacity;

    QueueUsingArray(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.front = -1;
        this.rear = -1;
    }

    QueueUsingArray(){
        this(5);
    }

    void enqueue(int val){
        //TC = O(1)
        if(this.rear+1 == this.capacity){
            System.out.println("Queue Overflow");
            return;
        }
        this.rear++;
        this.arr[this.rear] = val;
        if(this.front == -1){
            this.front++;
        }
    }

    int dequeue(){
        //TC = O(n)
        if(this.front == -1){
            System.out.println("Queue Underflow");
            return -1;
        }
        int i = this.front;
        int returnVal = this.arr[i];
        while(i != this.rear){
            this.arr[i] = this.arr[i+1];
            i++;
        }
        this.rear--;
        if(this.rear == -1){
            this.front--;
        }
        return returnVal;
    }

    int size(){
        return this.rear - this.front + 1;
    }

    boolean isFull(){
        return this.rear == this.capacity-1;
    }

    boolean isEmpty(){
        return this.front == -1;
    }

    int front(){
        if(this.front == -1){
            System.out.println("Queue Underflow");
            return -1;
        }
        return this.arr[this.front];
    }

    int rear(){
        if(this.front == -1){
            System.out.println("Queue Underflow");
            return -1;
        }
        return this.arr[this.rear];
    }

    void print(){
        if(this.front == -1){
            System.out.println("Queue is empty");
            return;
        }
        int i = this.front;
        while(i <= this.rear){
            System.out.print(this.arr[i]+" ");
            i++;
        }
        System.out.println();
    }
}
