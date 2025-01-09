package DynamicPrograming;
import java.util.*;

//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(robUsingSpaceOptimizedTabulation(nums));
        System.out.println(robUsingTabulation(nums));
        System.out.println(robUsingMemoizationLeftToRight(nums));
        System.out.println(robUsingMemoizationRightToLeft(nums));
    }

    private static int robUsingSpaceOptimizedTabulation(int[] nums) {
        //TC = O(n), SC = O(1)
        int n = nums.length;
        if(n == 1) return nums[0];
        int secPrev = nums[0], prev = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n; i++){
            int temp = Math.max(nums[i] + secPrev, prev);
            secPrev = prev;
            prev = temp;
        }
        return prev;
    }

    private static int robUsingTabulation(int[] nums) {
        //TC = O(n), SC = O(n)
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }

    private static int robUsingMemoizationLeftToRight(int[] nums) {
        //TC = O(n), SC = O(n)
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-1], nums[n-2]);
        return helper(nums, 0, n, dp);
    }

    private static int helper(int[] nums, int i, int n, int[] dp){
        if(dp[i] == -1){
            dp[i] = Math.max(nums[i] + helper(nums, i+2, n, dp), helper(nums, i+1, n, dp));
        }
        return dp[i];
    }

    private static int robUsingMemoizationRightToLeft(int[] nums) {
        //TC = O(n), SC = O(n)
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        return helper(nums, n-1, dp);
    }

    private static int helper(int[] nums, int n, int[] dp){
        if(dp[n] == -1){
            dp[n] = Math.max(nums[n] + helper(nums, n-2, dp), helper(nums, n-1, dp));
        }
        return dp[n];
    }
}
