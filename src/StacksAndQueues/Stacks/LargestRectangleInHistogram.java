package StacksAndQueues.Stacks;
import java.util.*;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {1,2,3,4};
        System.out.println(largestRectangleAreaMoreOptimizedAndConcise(heights));
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleAreaMoreOptimizedAndConcise(int[] heights){
        /*
        Objective: To simultaneously compute previous smaller and next smaller element index
        we are calculating the next smaller element index and previous smaller element index of heights[st.peek()]
        whenever heights[st.peek()] <= heights[i] we are on the increasing curve we cannot compute the next smaller and previous smaller immediately
        so, we store the index in stack to be later computed when we get heights[st.peek()] > heights[i]
        whenever heights[st.peek()] > heights[i] we are on the decreasing curve then heights[i] is the next smaller element of heights[st.peek()] so nse = i
        and element next to the st.peek() (2nd element in the stack next to top of the stack) is the previous smaller element of heights[st.peek()] so st.pop(); and pse = st.empty() ? -1 : st.peek(); because
        we were on the increasing curve previously and that is why index was waiting in the stack.

        At last i = n then the next smaller element index of all the elements in the stack is n (nge = n) and previous smaller is the element next to the top of the stack (st.pop(); and pse = st.empty() ? -1 : st.peek();)
        maxArea = Math.max(maxArea, (nse - pse - 1)*heights[st.peek()] that is height of the current bar * (distance between next smaller element index and previous smaller element index)

        we are storing the index in the stack because it will give us the distance between next smaller element index and previous smaller element index
         */

        //TC = O(n), SC = O(n)
        int n = heights.length, maxArea = Integer.MIN_VALUE, nse, pse, height;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<=n; i++){
            while(!st.empty() && ((i<n && heights[i] < heights[st.peek()]) || (i==n))){
                nse = i;
                height = heights[st.peek()];
                st.pop();
                pse = st.empty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, (nse - pse - 1) * height);
            }
            st.push(i);
        }
        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        int[] pse = helper(heights, false),
                nse = helper(heights, true);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i<heights.length; i++){
            maxArea = Math.max(maxArea, (nse[i] - pse[i] + 1)*heights[i]);
        }
        return maxArea;
    }

    private static int[] helper(int[] arr, boolean isNextSmaller){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int i = isNextSmaller ? n-1 : 0;
        while(isNextSmaller ? i>=0 : i<n){
            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.empty()){
                ans[i] = isNextSmaller ? n-1 : 0;
            }
            else{
                ans[i] = isNextSmaller ? st.peek()-1 : st.peek()+1;
            }
            st.push(i);
            i = isNextSmaller ? i-1 : i+1;
        }
        return ans;
    }
}
