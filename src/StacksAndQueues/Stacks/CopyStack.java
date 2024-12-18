package StacksAndQueues.Stacks;
import java.util.*;

public class CopyStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.addAll(List.of(1,2,3,4,5));
        Stack<Integer> copy = copyStack(st);
        System.out.println(copy);
        st.clear();
        st.addAll(List.of(1,2,3,4,5));
        copy = copyStackRecursive(st, new Stack<>());
        System.out.println(copy);
        st.clear();
        st.addAll(List.of(1,2,3,4,5));
        copy.clear();
        copyStackRecursive1(st, copy);
        System.out.println(copy);
    }

    private static Stack<Integer> copyStack(Stack<Integer> st){
        //TC=O(n), SC=O(n)
        Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();
        while(!st.empty()){
            st2.push(st.pop());
        }
        while(!st2.empty()){
            st1.push(st2.pop());
        }
        return st1;
    }

    private static Stack<Integer> copyStackRecursive(Stack<Integer> st, Stack<Integer> temp){
        //TC=O(n), SC=O(n)
        if(st.empty()){
            return new Stack<>();
        }
        temp.push(st.pop());
        Stack<Integer> ans = copyStackRecursive(st, temp);
        ans.push(temp.pop());
        return ans;
    }

    private static void copyStackRecursive1(Stack<Integer> st, Stack<Integer> result){
        if(st.empty()) return;
        int val = st.pop();
        copyStackRecursive1(st, result);
        result.push(val);
    }
}
