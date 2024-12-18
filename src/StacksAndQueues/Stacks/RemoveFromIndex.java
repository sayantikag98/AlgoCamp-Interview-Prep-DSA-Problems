package StacksAndQueues.Stacks;
import java.util.*;

public class RemoveFromIndex {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Collections.addAll(st, 1,2,3,4,5);
        removeFromIndex(st, 4, st.size());
        System.out.println(st);
        removeFromIndex(st, 2, st.size());
        System.out.println(st);
    }

    private static void removeFromIndex(Stack<Integer> st, int idx, int size){
        if(idx < 0 || idx >= size) {
            System.out.println("Invalid index");
            return;
        }
        idx = size - idx - 1;

        Stack<Integer> temp = new Stack<>();
        while(idx-->0){
            temp.push(st.pop());
        }
        st.pop();
        while(!temp.empty()){
            st.push(temp.pop());
        }
    }

    private static void removeFromIndexRecursive(Stack<Integer> st, int idx, int size){
        if(idx < 0 || idx >= size) {
            System.out.println("Invalid index");
            return;
        }
        if(st.size()-1 == idx){
            st.pop();
            return;
        }
        int val = st.pop();
        removeFromIndexRecursive(st, idx, size);
        st.push(val);
    }
}
