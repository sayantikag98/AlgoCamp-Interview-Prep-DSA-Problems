package StacksAndQueues.Stacks;
import java.util.*;

public class RemoveFromBottom {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Collections.addAll(st, 1,2,3,4,5);
        removeFromBottom(st);
        System.out.println(st);
        removeFromBottomRecursive(st, st.size());
        System.out.println(st);
    }

    private static void removeFromBottom(Stack<Integer> st){
        if(st.empty()){
            System.out.println("Stack is empty");
            return;
        }
        Stack<Integer> temp = new Stack<>();
        while(!st.empty()){
            temp.push(st.pop());
        }

        temp.pop();

        while(!temp.empty()){
            st.push(temp.pop());
        }
    }

    private static void removeFromBottomRecursive(Stack<Integer> st, int size){
        if(size <= 0) return;
        if(st.size() == 1){
            st.pop();
            return;
        }

        int val = st.pop();
        removeFromBottomRecursive(st, size);
        st.push(val);
    }
}
