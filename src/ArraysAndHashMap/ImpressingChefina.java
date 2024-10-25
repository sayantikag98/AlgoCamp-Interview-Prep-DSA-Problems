package ArraysAndHashMap;
import java.util.*;

//https://www.codechef.com/problems/CHFIMPRS
public class ImpressingChefina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] mat = new int[n][m];
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                    freq.put(mat[i][j], freq.getOrDefault(mat[i][j], 0) + 1);
                }
            }
            if (isImpressive(freq, n, m)) {
                for (int[] row : mat) {
                    for (int ele : row) {
                        System.out.print(ele + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println(-1);
            }
        }
    }

    private static boolean isImpressive(HashMap<Integer, Integer> freq, int n, int m) {
        //m is even
        if((m&1) == 0){
            //no of odd freq count has to be zero in order to be impressive
            for(int val: freq.values()){
                if((val&1) == 1) return false;
            }
        }
        //m is odd
        else{
            /*
            if n is odd, no of odd frequency count has to be odd and <= n
            if n is even, no of odd frequency count has to be even and <= n
            in order to be impressive
             */
            int countOdd = 0;
            for(int val:freq.values()){
                if((val&1) == 1) countOdd++;
                if(countOdd > n) return false;
            }
            if((n&1) == 0 && (countOdd & 1) == 1 || (n&1) == 1 && (countOdd & 1) == 0) return false;
        }
        return true;
    }
}
/*
3

1 2

1 1

2 2

1 1

2 1

3 3

1 2 3

6 5 4

7 8 9
 */
