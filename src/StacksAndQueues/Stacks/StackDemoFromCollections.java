package StacksAndQueues.Stacks;
import java.util.*;

public class StackDemoFromCollections {
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
//        st.pop();
        System.out.println(st.push(10));
        System.out.println(st.push(20));
        System.out.println(st.pop());
        System.out.println(st.empty());
        System.out.println(st.peek());
        System.out.println(st.push(100));
        System.out.println(st.push(1000));
        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.search(10));
        System.out.println(st.search(10000));

    }
}
