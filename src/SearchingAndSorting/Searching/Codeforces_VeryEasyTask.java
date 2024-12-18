package SearchingAndSorting.Searching;
import java.util.Scanner;

//https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/C
public class Codeforces_VeryEasyTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(minTime(n, x, y));
    }

    private static int minTime(int n, int x, int y){
        int low = 1, high = Math.max(x, y) * n, ans = high;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(isValid(n, mid, x, y)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isValid(int n, int minTime, int x, int y){
        if(minTime < Math.min(x, y)) return false;
        int totalCopy = (minTime - Math.min(x, y))/x + (minTime - Math.min(x, y))/y + 1;
        return n <= totalCopy;
    }
}
