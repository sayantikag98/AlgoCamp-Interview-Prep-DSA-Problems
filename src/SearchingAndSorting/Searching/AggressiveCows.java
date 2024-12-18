package SearchingAndSorting.Searching;
import java.util.*;

//https://www.spoj.com/problems/AGGRCOW/

//FOR SUBMITTING IN SPOJ REMOVE PACKAGE AND THE CLASS NAME SHOULD BE MAIN
public class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0) {
            int n = sc.nextInt(), c = sc.nextInt();
            int[] pos = new int [n];
            for(int i = 0; i<n; i++){
                pos[i] = sc.nextInt();
            }
            System.out.println(findMinDistance(pos, n, c));
        }
    }

    private static int findMinDistance(int[] pos, int n, int c){
        //TC = O(nlogn), SC = O(1)
        Arrays.sort(pos);
        /*
        for lower bound the minimum distance should be 1 because the cows should be atleast 1 distance apart

        for upper bound when total c = 2 then the minimum distance should be when the cows are farthest apart (at the extreme boundaries of the straight line)
         */
        int low = 1, high = pos[n-1] - pos[0], ans = low;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(isValid(pos, n, c, mid)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }

    private static boolean isValid(int[] pos, int n, int c, int minDist){
        int cows = 1, lastPlaced = pos[0];
        for(int i = 1; i<n; i++){
            int dist = pos[i] - lastPlaced;
            if(dist >= minDist){
                cows++;
                lastPlaced = pos[i];
            }
            if(cows == c) return true;
        }
        return false;
    }

}
