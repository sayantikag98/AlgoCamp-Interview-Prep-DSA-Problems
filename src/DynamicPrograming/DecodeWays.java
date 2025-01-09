package DynamicPrograming;
import java.util.*;

//https://leetcode.com/problems/decode-ways/description/
public class DecodeWays {
    public static void main(String[] args) {
        String str = "226";
        System.out.println(numDecodingsUsingMemoization(str));
        System.out.println(numDecodingsUsingTabulation(str));
        System.out.println(numDecodingsUsingSpaceOptimizedTabulation(str));
    }

    private static int numDecodingsUsingSpaceOptimizedTabulation(String s) {
        //TC = O(n), SC = O(1)
        int n = s.length(), next = 1, secNext = 1;
        for(int i = n-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                //Made mistake update secNext & next
                secNext = next;
                next = 0;
                continue;
            }
            int singleDigitDecoding = next;
            int doubleDigitDecoding = 0;
            if(i < n-1){
                int digit1 = s.charAt(i) - '0';
                int digit2 = s.charAt(i+1) - '0';
                int num = digit1*10 + digit2;
                if(num <= 26){
                    doubleDigitDecoding = secNext;
                }
            }
            int temp = singleDigitDecoding + doubleDigitDecoding;
            secNext = next;
            next = temp;
        }
        return next;
    }

    private static int numDecodingsUsingTabulation(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i>=0; i--){
            if(s.charAt(i) == '0') continue;
            int singleDigitDecoding = dp[i+1];
            int doubleDigitDecoding = 0;
            if(i < n-1){
                int digit1 = s.charAt(i) - '0';
                int digit2 = s.charAt(i+1) - '0';
                int num = digit1*10 + digit2;
                if(num <= 26){
                    doubleDigitDecoding = dp[i+2];
                }
            }
            dp[i] = singleDigitDecoding + doubleDigitDecoding;
        }
        return dp[0];
    }

    private static int numDecodingsUsingMemoization(String s) {
        //TC = O(n), SC = O(n)
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[n] = 1;
        return helper(s, 0, n, dp);
    }

    private static int helper(String s, int idx, int n, int[] dp){
        if(dp[idx] != -1) return dp[idx];
        if(s.charAt(idx) == '0') return 0;
        int singleDigitDecoding = helper(s, idx+1, n, dp);
        int doubleDigitDecoding = 0;
        if(idx < n-1){
            int digit1 = s.charAt(idx) - '0';
            int digit2 = s.charAt(idx+1) - '0';
            int num = digit1*10 + digit2;
            if(num <= 26){
                doubleDigitDecoding = helper(s, idx+2, n, dp);
            }
        }
        return dp[idx] = singleDigitDecoding + doubleDigitDecoding;
    }
}
