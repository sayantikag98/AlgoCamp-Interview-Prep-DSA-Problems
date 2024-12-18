package StacksAndQueues.Queues;
import java.util.*;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class QueueUsingStack{
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(10);
        q.push(20);
        System.out.println(q.pop());
        System.out.println(q.peek());
    }
}

class MyQueue{
    Stack<Integer> st1;
    public MyQueue() {
        st1 = new Stack<>();
    }

    public void push(int x) {
        //TC = O(n)
        Stack<Integer> st2 = new Stack<>();
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        st1.push(x);
        while(!st2.empty()){
            st1.push(st2.pop());
        }
    }

    public int pop() {
        //TC = O(1)
        return st1.pop();
    }

    public int peek() {
        //TC = O(1)
        return st1.peek();
    }

    public boolean empty() {
        //TC = O(1)
        return st1.empty();
    }


}
