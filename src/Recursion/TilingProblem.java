package Recursion;

public class TilingProblem {
    public static void main(String[] args) {
        System.out.println(countWays(3));
    }

    private static int countWays(int n){
        if(n == 0 || n == 1 || n == 2) return n;
        return countWays(n-1) + countWays(n-2);
    }
}
