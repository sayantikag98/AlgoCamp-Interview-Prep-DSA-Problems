package Recursion;

public class PowerSum {

    static int count = 0;
    public static void main(String[] args) {
        int n = 10, x = 1000, power = (int) Math.pow(x, (double)1/n), ans;
//        countWaysRecursive(n, x, 1, new int[power+1]);
//        System.out.println(count);
//        ans = countWaysIterative(n, x, power);
//        System.out.println(ans);

        System.out.println(countPowerSumMostOptimizedUsingSubsequences(x, n, 1, power));
    }


    private static int countPowerSumMostOptimizedUsingSubsequences(int x, int n, int i, int power){
        if(i == power+1){
            if(x == 0) return 1;
            return 0;
        }

        int ans = 0;

        //i^n included
        ans += countPowerSumMostOptimizedUsingSubsequences(x - (int)Math.pow(i, n), n, i+1, power);

        //i^n excluded
        ans += countPowerSumMostOptimizedUsingSubsequences(x, n, i+1, power);

        return ans;
    }

    private static void countWaysRecursive(int n, int x, int i, int[] ways){
        if(x == 0) {
            count++;
        }
        if(i == 0 || i == ways.length+1) return;

        if(x <= 0) {
            x += (int)Math.pow(ways[i-1], n);
            ways[i-1] = 0;
            countWaysRecursive(n, x + (int)Math.pow(ways[i-2], n), i-2, ways);
        }
        else{
            if(i<ways.length) {
                if (ways[i] == 0) ways[i] = ways[i - 1] + 1;
                else ways[i] = ways[i] + 1;
                countWaysRecursive(n, x - (int) Math.pow(ways[i], n), i + 1, ways);
            }
        }
    }

    private static int countWaysIterative(int n, int x, int power){
        int[] ways = new int[power+1];
        int i = 1, ans = 0;
        while(i>=1 && i<ways.length){
            if (ways[i] == 0) {
                ways[i] = ways[i-1]+1;
            } else {
                ways[i] = ways[i]+1;
            }
            x -= (int)Math.pow(ways[i], n);
            if(x > 0) {
                i++;
            }
            if(x == 0) ans++;
            if(x <= 0){
                x += (int)Math.pow(ways[i-1], n);
                x += (int)Math.pow(ways[i], n);
                ways[i] = 0;
                i--;
            }
        }
        return ans;
    }
}

/*
1^2 + 2^2 + 3^2 + 4^2 is invalid
1^2 + 2^2 + 4^2
 */
