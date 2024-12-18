package StacksAndQueues.Stacks;
import java.util.*;

public class InsertAtIndex {
    public static void main(String[] args) {
        int val = 100, idx = 6;
        Stack<Integer> st = new Stack<>();
        st.addAll(List.of(1,2,3,4,5,6));
        insertAtIndex(st, val, idx);
        System.out.println(st);
        insertAtIndexRecursive(st, val, idx, st.size());
        System.out.println(st);
    }

    private static void insertAtIndex(Stack<Integer> st, int val, int idx){
        if(idx < 0 || idx > st.size()){
            System.out.println("Invalid index");
            return;
        }
        //index computed from bottom
        idx = st.size() - idx;

        Stack<Integer> temp = new Stack<>();
        while(!st.empty() && idx-->0){
            temp.push(st.pop());
        }
        st.push(val);
        while(!temp.empty()){
            st.push(temp.pop());
        }
    }

    private static void insertAtIndexRecursive(Stack<Integer> st, int val, int idx, int size){
        //MADE MISTAKE => st.size() will update every time you pop or push elements
        if(idx < 0 || idx > size){
            System.out.println("Invalid index");
            return;
        }
        if(st.size() == idx){
            st.push(val);
            return;
        }
        int top = st.pop();
        insertAtIndexRecursive(st, val, idx, size);
        st.push(top);
    }
}
