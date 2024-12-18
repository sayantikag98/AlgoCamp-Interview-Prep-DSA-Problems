package SearchingAndSorting.Searching;

//https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
public class FindTheSmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        System.out.println(smallestDivisor(nums, threshold));
    }

    private static int smallestDivisor(int[] nums, int threshold) {
        //TC = O(n*log 1000000), log 1000000 ~ 20
        //1 <= nums[i] <= 106 check constraint for upper bound of search space
        int low = 1, high = 1000000, ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isValid(nums, threshold, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isValid(int[] nums, int threshold, int divisor){
        long sum = 0;
        for(var ele: nums){
            double result = Math.ceil((double) ele/divisor);
            sum = sum + (int)result;
        }
        return sum <= threshold;
    }
}
