package StacksAndQueues.Stacks;
import java.util.*;

//https://leetcode.com/problems/min-stack/description/
public class MinStackDemo {
    public static void main(String[] args) {
        MinStackUsingSingleStack obj = new MinStackUsingSingleStack();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-2147483648);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

class MinStackUsingSingleStack{
    /*
    store val - min in the stack and min = Math.min(min, val)
    if(val>=min) then val-min will be positive or zero then minimum will not update
    if(val<min) then val-min will be negative then minimum will update
    retrieve original value for top -> val = top + min
     */

    //here taking long is necessary because of the constraint given like when doing st.push(val - min) this could overflow for int as val = -2147483648 and min = 2147483647
    Stack<Long> st;
    long min;
    MinStackUsingSingleStack(){
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }

    //all methods have TC = O(1) and SC = O(1)
    public void push(int val) {
        if(st.empty()){
            st.push((long)val);
        }
        else{
            st.push(val - min);
        }
        min = Math.min(min, val);
    }

    public void pop() {
        /*
        min is only updated for negative values present in the stack
        if(val>=min) then val-min will be positive or zero then minimum will not update
        if(val<min) then val-min will be negative then minimum will update
         */
        if(st.peek() < 0){
            min = min - st.peek();
        }
        st.pop();
        if(st.empty()){
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        /*
        The error Inconvertible types; cannot cast 'java.lang.Long' to 'int' occurs in Java when trying to cast an object of type Long (wrapper class for long) to an int (primitive type) without an explicit conversion.
        intValue() Method: This is a method in the Long wrapper class that converts the Long object to an int, handling the casting explicitly.
        Potential Data Loss: Be cautious! Casting from a Long to an int may result in data loss if the Long value exceeds the range of int (-2^31 to 2^31-1).
         */

        //when stack had only 1 element that is the original value only and not val - min
        if(st.size() == 1) return st.peek().intValue();

        //retrieve original value for top -> val = st.peek() + min when st.peek() is a positive value
        if(st.peek() >= 0){
            //don't do something like this return (int)(st.peek().intValue() + min) because st.peek() may be outside the range of integer
            long peekVal = st.peek();
            return (int)(peekVal + min);
        }

        //when st.peek() is a negative value min was only updated so the original value for top = st.peek() + previous_min
        //previous_min = min - st.peek()
        //so the original value for top = st.peek() + previous_min = st.peek() + min - st.peek() = min
        else{
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
    }
}

class MinStackUsingLinkedList{
    private Node head;

    private static class Node{
        int val;
        int min;
        Node next;

        Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    MinStackUsingLinkedList(){
        this.head = null;
    }

    public void push(int val) {
        int minVal = this.head == null || val < this.head.min ? val : this.head.min;
        Node newNode = new Node(val, minVal);
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        this.head = this.head.next;
    }

    public int top() {
        return this.head.val;
    }

    public int getMin() {
        return this.head.min;
    }

}

class MinStackUsingTwoStacks {

    Stack<Integer> minStack, st;
    public MinStackUsingTwoStacks() {
        minStack = new Stack<>();
        st = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if(minStack.empty() || val < minStack.peek()){
            minStack.push(val);
        }
        else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        st.pop();
        minStack.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
