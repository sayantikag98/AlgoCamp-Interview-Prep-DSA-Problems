//package DynamicPrograming;
import java.util.*;

//https://cses.fi/problemset/task/1635
public class CoinCombinationsI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt();
        int[] denominations = new int[n];
        for(int i = 0; i<n; i++){
            denominations[i] = sc.nextInt();
        }
        Arrays.sort(denominations);
        System.out.println(totalCount(denominations, n, s));
//        System.out.println(totalCountTabulation(denominations, n, s));
    }

    private static int totalCount(int[] denominations, int n, int s){
        int mod = 1000000007;
        int[] dp = new int[s+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(denominations, n, s, dp, mod);
    }

    private static int helper(int[] denominations, int n, int s, int[] dp, int mod){
        if(dp[s] == -1){
            dp[s] = 0;
            for(int denomination: denominations){
                if(s - denomination >= 0){
                    dp[s] = (dp[s] + helper(denominations, n, s-denomination, dp, mod))%mod;
                }
                else break;
            }
        }
        return dp[s];
    }

//    private static int totalCountTabulation(int[] denominations, int n, int s){
//        int mod = 1000000007;
//        int[] dp = new int[s+1];
//        dp[0] = 1;
//        for(int i = 1; i<=s; i++){
//            for(int denomination: denominations){
//                if(i - denomination >= 0){
//                    dp[i] = (dp[i] + dp[i-denomination])%mod;
//                }
//                else break;
//            }
//        }
//        return dp[s];
//    }

}
