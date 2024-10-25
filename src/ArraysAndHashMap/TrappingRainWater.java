package ArraysAndHashMap;
import java.util.Stack;

//https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trapUsingStack(height));
        System.out.println(trapMoreOptimized(height));
        System.out.println(trapMostOptimizedUsingTwoPointers(height));
    }

    private static int trapMostOptimizedUsingTwoPointers(int[] height) {
        //TC = O(n), SC = O(1)
        int leftMax = 0, rightMax = 0, total = 0, l = 0, r = height.length-1;
        while(l<r){
            if(height[l] <= height[r]){
                leftMax = Math.max(leftMax, height[l]);
                total += (leftMax - height[l]);
                l++;
            }
            else{
                rightMax = Math.max(rightMax, height[r]);
                total += (rightMax - height[r]);
                r--;
            }
        }
        return total;
    }

    private static int trapMoreOptimized(int[] height) {
        //TC = O(n), SC = O(n)
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            if(st.isEmpty() || height[i]>height[st.peek()]){
                st.push(i);
            }
        }
        int sum = 0, lgt = height[0], rgt = height[st.peek()];
        for(int i = 0; i<n; i++){
            if(i != 0) lgt = Math.max(lgt, height[i]);
            sum += (Math.min(lgt, rgt) - height[i]);
            if(i == st.peek()){
                st.pop();
                if(i!=n-1) rgt = height[st.peek()];
            }
        }
        return sum;
    }

    private static int trap(int[] height) {
        //TC = O(n), SC = O(n)
        int n = height.length, sum = 0, nger = height[n-1];
        int[] ngel = new int[n];
        ngel[0] = height[0];
        for(int i = 1; i<n; i++){
            ngel[i] = Math.max(ngel[i-1], height[i]);
        }
        for(int i = n-1; i>=0; i--){
            if(i != n-1) nger = Math.max(nger, height[i]);
            sum+=(Math.min(nger, ngel[i])-height[i]);
        }
        return sum;
    }

    private static int trapUsingStack(int[] height) {
        //TC = O(n), SC = O(n)
        Stack<Integer> st = new Stack<>();
        int i = 0, n = height.length;
        int[] nger = new int[n], ngel = new int[n];
        while(i<n){
            if(st.isEmpty()){
                ngel[i] = -1;
                st.push(i);
                i++;
            }
            else{
                if(height[i]<height[st.peek()]){
                    ngel[i] = st.peek();
                    i++;
                }
                else{
                    while(!st.isEmpty() && height[i]>=height[st.peek()]){
                        st.pop();
                    }
                }
            }
        }
        st.clear();
        i = n-1;
        int sum = 0;
        while(i>=0){
            if(st.isEmpty()){
                nger[i] = -1;
                st.push(i);
                i--;
            }
            else{
                if(height[i]<height[st.peek()]){
                    nger[i] = st.peek();
                    if(ngel[i] != -1){
                        sum+= (Math.min(height[ngel[i]], height[nger[i]]) - height[i]);
                    }
                    i--;
                }
                else{
                    while(!st.isEmpty() && height[i]>=height[st.peek()]){
                        st.pop();
                    }
                }
            }
        }
        return sum;
    }
}
