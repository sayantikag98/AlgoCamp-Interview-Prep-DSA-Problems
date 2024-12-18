package StacksAndQueues.Stacks;
import java.util.*;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Collections.addAll(st, 1,2,3,4,5);
        reverse(st);
        System.out.println(st);
        reverseRecursive(st, new Stack<>());
        System.out.println(st);
        reverseRecursive1(st);
        System.out.println(st);
        reverseRecursive2(st, new Stack<>());
        System.out.println(st);

    }

    private static void reverse(Stack<Integer> st){
        Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();
        while(!st.empty()){
            st1.push(st.pop());
        }
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        while(!st2.empty()){
            st.push(st2.pop());
        }
    }

    private static void reverseRecursive(Stack<Integer> st, Stack<Integer> temp){
        //TC = O(n^2), SC = O(n)
        //stores the reverse of stack in temp
       if(st.empty()) return;
       temp.push(st.pop());
       reverseRecursive(st, temp);


       //copy the reverse of stack stored in temp back to st
       helper(temp, st);
    }

    private static void helper(Stack<Integer> temp, Stack<Integer> st){
        if(temp.empty()){
            return;
        }
        int val = temp.pop();
        helper(temp, st);
        st.push(val);
    }

    private static void reverseRecursive1(Stack<Integer> st){
        if(st.empty()) return;
        int val = st.pop();
        reverseRecursive1(st);
        insertAtBottom(st, val);
    }

    private static void insertAtBottom(Stack<Integer> st, int val){
        //TC = O(n^2), SC = O(n)
        if(st.empty()){
            st.push(val);
            return;
        }
        int top = st.pop();
        insertAtBottom(st, val);
        st.push(top);
    }

    private static void reverseRecursive2(Stack<Integer> st, Stack<Integer> temp){
        //TC=O(n), SC=O(n)
        
        //first reverse and then copy back
//        reverseIntoAnother(st, temp);
//        copyIntoAnother(temp, st);

        //first copy and then reverse back
        copyIntoAnother(st, temp);
        reverseIntoAnother(temp, st);
    }

    private static void reverseIntoAnother(Stack<Integer> st1, Stack<Integer> st2){
        //st2 will have the reverse of st1
        if(st1.empty()){
            return;
        }
        st2.push(st1.pop());
        reverseIntoAnother(st1, st2);
    }

    private static void copyIntoAnother(Stack<Integer> st1, Stack<Integer> st2){
        //st2 will have the same copy of st1
        if(st1.empty()){
            return;
        }
        int val = st1.pop();
        copyIntoAnother(st1, st2);
        st2.push(val);
    }
}
