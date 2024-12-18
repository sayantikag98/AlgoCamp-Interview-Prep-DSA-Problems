package StacksAndQueues.Queues;
import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(List.of(1,2,3,4,5));
        System.out.println(q);
        System.out.println(reverse(q));
        System.out.println(q);
    }

    private static Queue<Integer> reverse(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.poll());
        }

        while(!st.empty()){
            q.offer(st.pop());
        }

        return q;
    }
}
