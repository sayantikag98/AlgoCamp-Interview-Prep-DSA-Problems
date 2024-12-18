package StacksAndQueues.Stacks;
import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4,2,3,5,7,2,4,5,6};
        int[] nge = findNextGreaterElement(arr);
        for(var ele: nge){
            System.out.print(ele+" ");
        }
        System.out.println();
        nge = findNextGreaterElementOptimized(arr);
        for(var ele: nge){
            System.out.print(ele+" ");
        }
        System.out.println();
        nge = findNextGreaterElementOptimized1(arr);
        for(var ele: nge){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    private static int[] findNextGreaterElementOptimized(int[] arr){
        //TC = O(n), SC = O(n)
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        //iterate from right to left
        for(int i = n-1; i>=0; i--){
            while(!st.empty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.empty()){
                nge[i] = -1;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return nge;
    }

    private static int[] findNextGreaterElementOptimized1(int[] arr){
        int n = arr.length;
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.empty() && arr[st.peek()] < arr[i]){
                nge[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        return nge;
    }

    private static int[] findNextGreaterElement(int[] arr){
        //TC = O(n^2), SC = O(1)
        int n = arr.length;
        int[] nge = new int[n];
        for(int i = 0; i<n; i++){
            int j = i+1;
            while(j<n && arr[j] <= arr[i]){
                j++;
            }
            if(j == n){
                nge[i] = -1;
            }
            else{
                nge[i] = arr[j];
            }
        }
        return nge;
    }


}
