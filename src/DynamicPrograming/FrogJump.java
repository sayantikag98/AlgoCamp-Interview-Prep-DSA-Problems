package DynamicPrograming;
import java.util.*;

//https://www.naukri.com/code360/problems/frog-jump_3621012
public class FrogJump {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10,20,30,10};
        System.out.println(frogJumpUsingDPSpaceOptimized(n, heights));
        System.out.println(frogJumpUsingDPTabulation(n, heights));
    }

    private static int frogJumpUsingDPSpaceOptimized(int n, int[] heights) {
        if(n == 1) return 0;
        int second = 0, first = Math.abs(heights[n-2] - heights[n-1]);
        for(int i = n-3; i>=0; i--){
            int temp = Math.min(Math.abs(heights[i] - heights[i+1]) + first, Math.abs(heights[i] - heights[i+2]) + second);
            second = first;
            first = temp;
        }
        return first;
    }

    private static int frogJumpUsingDPTabulation(int n, int[] heights) {
        if(n == 1) return 0;
        int[] dp = new int[n];
        dp[n-1] = 0;
        dp[n-2] = Math.abs(heights[n-2] - heights[n-1]);
        for(int i = n-3; i>=0; i--){
            dp[i] = Math.min(Math.abs(heights[i] - heights[i+1]) + dp[i+1], Math.abs(heights[i] - heights[i+2]) + dp[i+2]);
        }
        return dp[0];
    }

    public static int frogJumpUsingDPMemoization(int n, int heights[]) {
        if(n==1) return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[n] = dp[n-1] = 0;
        dp[n-2] = Math.abs(heights[n-2] - heights[n-1]);
        //todo: min cost to travel from 0 to n-1
        return helper(n, heights, dp, 0);
    }

    private static int helper(int n, int[] heights, int[] dp, int i){
        //moving from left to right
        //min cost to travel from i to n-1
        if(dp[i] == -1){
            dp[i] = Math.min(Math.abs(heights[i] - heights[i+1]) + helper(n, heights, dp, i+1), Math.abs(heights[i] - heights[i+2]) + helper(n, heights, dp, i+2));
        }
        return dp[i];
    }
}
