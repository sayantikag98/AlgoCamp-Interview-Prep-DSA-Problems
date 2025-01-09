package DynamicPrograming;
import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 30;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(findingFibonacciWithDPMemoization(n, dp));
        System.out.println(findingFibonacciWithDPTabulation(n));
        System.out.println(findingFibonacciWithDpSpaceOptimized(n));
        System.out.println(findingFibonacciWithoutDP(n));
    }

    private static int findingFibonacciWithDpSpaceOptimized(int n){
        //TC = O(n), SC = O(1)
        int prev = 1, secPrev = 0;
        for(int i = 2; i<=n; i++){
            int temp = prev + secPrev;
            secPrev = prev;
            prev = temp;
        }
        return prev;
    }

    private static int findingFibonacciWithDPTabulation(int n){
        //TC = O(n), SC = O(n) [dp tabulation array]
        int[] dp = new int[n+1];
        //no need to initialize the array with -1
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static int findingFibonacciWithDPMemoization(int n, int[] dp){
        //Assume no negative values of n
        //TC = O(n), SC = O(n) + O(n) [recursive stack space + dp memoization array]
        if(n < 2) return dp[n];
        if(dp[n] == -1){
            dp[n] = findingFibonacciWithDPMemoization(n-1, dp) + findingFibonacciWithDPMemoization(n-2, dp);
        }
        return dp[n];
    }

    private static int findingFibonacciWithoutDP(int n){
        //TC = O(2^n), SC = O(n)
        if(n<2) return n;
        return findingFibonacciWithoutDP(n-1) + findingFibonacciWithoutDP(n-2);
    }

}
