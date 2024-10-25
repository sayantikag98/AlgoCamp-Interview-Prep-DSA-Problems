package TwoPointers;
import java.util.Scanner;

//https://codeforces.com/problemset/problem/676/C
public class Codeforces676CVasyaAndString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String s = sc.next();
        System.out.println(countMax(s, n, k));
    }

    private static int countMax(String s, int n, int k){
        int i = 0, count = 0;
        for(int j = 0; j<n; j++){
            if(s.charAt(j) == 'a') count++;
            if(Math.min(count, j-i+1-count)>k){
                if(s.charAt(i) == 'a') count--;
                i++;
            }
        }
        return n-i;
    }
}
