package DynamicPrograming;
import java.util.*;

//https://atcoder.jp/contests/dp/tasks/dp_b
public class FrogJump2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] height = new int[n];
        for(int i = 0; i<n; i++){
            height[i] = sc.nextInt();
        }
        System.out.println(minCostUsingMemoization(height, n, k));
        System.out.println(minCostUsingTabulation(height, n, k));
    }

    private static int minCostUsingTabulation(int[] height, int n, int k){
        int[] dp = new int[n];
        for(int i = n-2; i>=0; i--){
            int ans = Integer.MAX_VALUE;
            for(int j = 1; j<=k && i+j < n; j++){
                ans = Math.min(ans, Math.abs(height[i] - height[i+j]) + dp[i+j]);
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    private static int minCostUsingMemoization(int[] height, int n, int k){
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        return helper(height, 0, n, k, dp);
    }

    private static int helper(int[] height, int i, int n, int k, int[] dp){
        if(dp[i] != Integer.MAX_VALUE) return dp[i];
        for(int j = 1; j<=k && i+j < n; j++){
            dp[i] = Math.min(dp[i], Math.abs(height[i] - height[i+j]) + helper(height, i+j, n, k, dp));
        }
        return dp[i];
    }


//    private static int minCost(int[] height, int n, int k) {
//
//        /*
//        this is Incorrect
//       so the correct way to initially initialize the array with Integer.MAX_VALUE and then dp[i] = Math.min(dp[i], Math.abs(height[i] - height[i+j]) + dp[i+j])
//         */
//        int[] dp = new int[n];
//
//        for (int i = n - 2; i >= 0; i--) {
//            for (int j = 1; j <= k && i+j < n; j++) {
//                if(dp[i] == 0){
//                    dp[i] = Math.abs(height[i] - height[i + j]) + dp[i + j];
//                }
//                else dp[i] = Math.min(dp[i], Math.abs(height[i] - height[i + j]) + dp[i + j]);
//            }
//        }
//        return dp[0];
//    }
}
