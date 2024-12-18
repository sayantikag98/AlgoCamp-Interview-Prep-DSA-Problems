package StacksAndQueues.Queues;
import java.util.*;

//https://leetcode.com/problems/implement-stack-using-queues/
public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}

class MyStack {
    Queue<Integer> q;
    public MyStack() {
        this.q = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> q1 = new LinkedList<>();
        while(!q.isEmpty()){
            q1.offer(q.poll());
        }
        q.offer(x);
        while(!q1.isEmpty()){
            q.offer(q1.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
