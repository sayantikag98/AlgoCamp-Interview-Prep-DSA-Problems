package StacksAndQueues.Stacks;
import java.util.*;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {2,35,1,12,34,5,1,35,63,5};
        int[] pge = findPreviousGreaterElement(arr);
        System.out.println(Arrays.toString(pge));
        pge = findPreviousGreaterElement1(arr);
        System.out.println(Arrays.toString(pge));
    }

    private static int[] findPreviousGreaterElement(int[] arr){
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            //pop till not satisfying condition for previous greater
            while(!st.empty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.empty()){
                pge[i] = -1;
            }
            else{
                pge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return pge;
    }

    private static int[] findPreviousGreaterElement1(int[] arr){
        int n = arr.length;
        int[] pge = new int[n];
        Arrays.fill(pge, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            //check if the arr[i] is the previous greater for arr[st.peek()] if its satisfied then pop the index and check the next index in the stack
            //if the condition is not satisfied for the index at st.peek() then it will also not satisfy the condition for other index waiting in the stack
            while(!st.empty() && arr[st.peek()] < arr[i]){
                pge[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        return pge;
    }
}
