package StacksAndQueues.Queues;

class MyCircularQueue{
    private final int[] arr;
    private int front;
    private int rear;
    private int size;

    MyCircularQueue(int capacity){
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    MyCircularQueue(){
        this(10);
    }

    void offer(int val){
        if(this.arr.length == 0 || this.size == this.arr.length){
            return;
        }
        if(this.front == -1){
            this.rear++;
            this.arr[this.rear] = val;
            this.front++;
            this.size++;
        }
        else{
            if(this.rear == this.arr.length-1){
                if(this.front != 0){
                    this.arr[0] = val;
                    this.rear = 0;
                    this.size++;
                }
            }
            else if(this.rear+1 < this.front){
                this.rear++;
                this.arr[this.rear] = val;
                this.size++;
            }
            else if(this.rear >= this.front){
                this.rear++;
                this.arr[this.rear] = val;
                this.size++;
            }
        }

    }

    int poll(){
        if(this.front == -1 || this.size == 0){
            return -1;
        }
        int delVal = this.arr[this.front];
        if(this.front + 1 < this.arr.length){
            this.front++;
            this.size--;
        }
        else{
            this.front = 0;
            this.size--;
        }
        return delVal;
    }

    int peek(){
        if(this.front == -1 || this.size == 0){
            return -1;
        }
        return this.arr[this.front];
    }

    int size(){
        return this.size;
    }

    void print(){
        int i = this.front;
        if(this.rear < this.front){
            while(i<this.arr.length){
                System.out.print(this.arr[i] + " ");
                i++;
            }
            i = 0;
            while(i<=this.rear){
                System.out.print(this.arr[i] + " ");
                i++;
            }
        }
        else{
            while(i<=this.rear){
                System.out.print(this.arr[i] + " ");
                i++;
            }
        }
        System.out.println();
    }
}
public class CircularQueue {
    public static void main(String[] args) {
        MyCircularQueue cq = new MyCircularQueue(5);
        cq.offer(10);
        cq.print();
        cq.offer(20);
        cq.print();
        cq.offer(30);
        cq.print();
        cq.offer(40);
        cq.print();
        cq.offer(50);
        cq.print();
        cq.offer(60);
        cq.print();
        cq.poll();
        cq.print();
        cq.offer(60);
        cq.print();

    }
}
