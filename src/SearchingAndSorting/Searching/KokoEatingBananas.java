package SearchingAndSorting.Searching;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }
    private static int minEatingSpeed(int[] piles, int h) {
        //TC = O(n) + O(n*(log max of arr[i] where 0<=i<n))
        int low = 1, high = getMax(piles), ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isValid(piles, h, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isValid(int[] piles, int h, int k){
        int sum = 0;
        for(var ele: piles){
            int hour = ele/k;
            if(ele%k != 0) hour++;
            sum += hour;
            if(sum > h) return false;
        }
        return true;
    }

    private static int getMax(int[] piles){
        int max = piles[0];
        for(int i = 1; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}
