package StacksAndQueues.Stacks;
import java.util.*;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {3,2,4,6,2,13,4,56,7,32};
        int[] nse = findNextSmallerElement(arr);
        for(var ele: nse){
            System.out.print(ele+" ");
        }
        System.out.println();
        nse = findNextSmallerElement1(arr);
        for(var ele: nse){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    private static int[] findNextSmallerElement(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!st.empty() && st.peek()>=arr[i]){
                //this can never be the next smaller element of arr[i] or any element to the left of arr[i]
                st.pop();
            }
            if(st.empty()){
                nse[i] = -1;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nse;
    }

    private static int[] findNextSmallerElement1(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Arrays.fill(nse, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.empty() &&  arr[i] < arr[st.peek()]){
                nse[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        return nse;
    }
}
