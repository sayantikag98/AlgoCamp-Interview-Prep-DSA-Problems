package SearchingAndSorting.Searching;

//https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
    private static int firstBadVersion(int n) {
        int low = 1, high = n, ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isBadVersion(int n){
        return n>3;
    }
}
