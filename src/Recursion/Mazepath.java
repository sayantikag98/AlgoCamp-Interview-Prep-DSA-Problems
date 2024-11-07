package Recursion;

public class Mazepath {
    public static void main(String[] args) {
        printAllPaths(0, 0, 3,  3, "");
        System.out.println(countWays(0, 0, 3, 3));
    }

    private static void printAllPaths(int i, int j, int n, int m, String ans){
        if(i == n-1 && j == m-1){
            System.out.println(ans);
            return;
        }
        if(i == n || j == m) return;

        printAllPaths(i+1, j, n, m, ans+'D');
        printAllPaths(i, j+1, n, m, ans+'R');
    }

    private static int countWays(int i, int j, int n, int m){
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(i == n || j == m) return 0;

        return countWays(i+1, j, n, m) + countWays(i, j+1, n, m);
    }
}
