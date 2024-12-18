package StacksAndQueues.Stacks;
import java.util.*;

public class InsertAtBottom {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.addAll(List.of(1,2,3,4,5));
        insertAtBottom(st, 0);
        System.out.println(st);
        st.clear();
        st.addAll(List.of(1,2,3,4,5));
        insertAtBottomRecursive(st, 0);
        System.out.println(st);
    }

    private static void insertAtBottom(Stack<Integer> st, int val){
        //TC= O(n), SC = O(n)
        Stack<Integer> temp = new Stack<>();
        while(!st.empty()){
            temp.push(st.pop());
        }
        st.push(val);
        while(!temp.empty()){
            st.push(temp.pop());
        }
    }

    private static void insertAtBottomRecursive(Stack<Integer> st, int val){
        //TC = O(n), SC = O(n)
        if(st.empty()){
            st.push(val);
            return;
        }
        int top = st.pop();
        insertAtBottomRecursive(st, val);
        st.push(top);
    }
}
