package StacksAndQueues.Stacks;

public class StackUsingArray {
    private final int[] arr;
    private int top_idx;

    StackUsingArray(int capacity){
        this.arr = new int[capacity];
        this.top_idx = -1;
    }

    StackUsingArray(){
        this(10);
    }

    void push(int ele){
        if(this.top_idx == this.arr.length-1){
            System.out.println("Stack Overflow");
        }
        else{
            this.arr[++this.top_idx] = ele;
        }
    }

    int pop(){
        if(this.top_idx == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            int popElement = this.arr[this.top_idx];
            this.arr[this.top_idx--] = 0;
            return popElement;
        }
    }

    int peek(){
        if(this.top_idx == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            return this.arr[this.top_idx];
        }
    }

    int size(){
        return this.top_idx+1;
    }

    boolean isEmpty(){
        return this.top_idx == -1;
    }

    boolean isFull(){
        return this.top_idx == this.arr.length-1;
    }

    int capacity(){
        return this.arr.length;
    }

    void print(){
        if(this.top_idx == -1){
            System.out.println("Stack is empty");
        }
        else{
            for(int i = 0; i<=this.top_idx; i++){
                System.out.print(this.arr[i] + " ");
            }
            System.out.println();
        }
    }
}
