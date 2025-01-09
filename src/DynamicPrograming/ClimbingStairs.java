package DynamicPrograming;
import java.util.*;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairsUsingDPSpaceOptimized(n));
        System.out.println(climbStairsUsingDPTabulation(n));
        System.out.println(climbStairsUsingDPMemoization(n));
    }

    private static int climbStairsUsingDPSpaceOptimized(int n) {
        //TC = O(n), SC = O(1)
        if(n<3) return n;
        int prev = 2, secPrev = 1;
        for(int i = 3; i<=n; i++){
            int temp = prev + secPrev;
            secPrev = prev;
            prev = temp;
        }
        return prev;
    }

    private static int climbStairsUsingDPTabulation(int n) {
        //TC = O(n), SC = O(n)
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    private static int climbStairsUsingDPMemoization(int n) {
        if(n<3) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return dpMemoization(n, dp);
    }

    private static int dpMemoization(int n, int[] dp){
        if(n>2 && dp[n] == -1){
            dp[n] = dpMemoization(n-1, dp) + dpMemoization(n-2, dp);
        }
        return dp[n];
    }
}
