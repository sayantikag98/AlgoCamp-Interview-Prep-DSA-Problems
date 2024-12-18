package StacksAndQueues.Stacks;
import java.util.*;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] arr = {2,45,66,73,2,34,56,7,7,87,8};
        int[] pse = findPreviousSmallerElement(arr);
        System.out.println(Arrays.toString(pse));
        pse = findPreviousSmallerElement1(arr);
        System.out.println(Arrays.toString(pse));
    }

    private static int[] findPreviousSmallerElement(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        //iterate from left to right
        for(int i = 0; i<n; i++){
            while(!st.empty() && st.peek() >= arr[i]){
                st.pop();
            }
            if(st.empty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return pse;
    }

    private static int[] findPreviousSmallerElement1(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                pse[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        return pse;
    }
}
