package FixedSlidingWindow;
import java.util.Arrays;

//https://leetcode.com/problems/k-radius-subarray-averages/description/

public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3)));
    }
    private static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        //k element to the left, k element to the right, and the element itself
        int win = 2*k+1;
        //if n is less than win then answer will be all -1
        if(n>=win){
            long sum = 0;
            for(int i = 0; i<n; i++){
                if(i >= win) sum-=nums[i-win];
                sum+=nums[i];
                if(i >= win-1){
                    ans[i-k] = (int)(sum/win); // MADE MISTAKE IN TYPE CASTING LONG TO INT
                }
            }
        }
        return ans;
    }
}
