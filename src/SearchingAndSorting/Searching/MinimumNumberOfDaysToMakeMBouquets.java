package SearchingAndSorting.Searching;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 3;
        System.out.println(minDays(bloomDay, m , k));
    }

    private static int[] getMinMax(int[] arr){
        int[] ans = {arr[0], arr[0]};
        for(int i = 1; i<arr.length; i++){
            ans[0] = Math.min(ans[0], arr[i]);
            ans[1] = Math.max(ans[1], arr[i]);
        }
        return ans;
    }

    private static int minDays(int[] bloomDay, int m, int k) {
        //TC = O(n * log d) where n is the total no of elements in given array and d is the maximum element in the given array
        int low = getMinMax(bloomDay)[0], high = getMinMax(bloomDay)[1], ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isValid(bloomDay, m, k, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int m, int k, int d){
        //to check if in d days is possible to bloom total k adjacent flowers is m
        if((long)m * k > arr.length) return false;

        int total = 0, kAdjacentCount = 0;
        //total calculates how many k adjacent flowers can bloom in d days
        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= d){
                kAdjacentCount++;
            }
            else{
                kAdjacentCount = 0;
            }

            if(kAdjacentCount == k){
                total++;
                kAdjacentCount = 0;
            }

            if(total == m) return true;

        }
        return false;
    }
}
