package SlidingWindowLeetcode;

//https://leetcode.com/problems/count-number-of-nice-subarrays/
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }
    private static int numberOfSubarrays(int[] nums, int k) {
        //similar solution as Leetcode 930. Binary Subarrays With Sum (https://leetcode.com/problems/binary-subarrays-with-sum/description/)
        //TC = O(2*2N), SC = O(1)
        //total no of subarrays with no of odds equal k = total no of subarrays with no of odds <= k - total no of subarrays with no of odds <= k-1
        return countSubArrays(nums, k) - countSubArrays(nums, k-1);
    }

    private static int countSubArrays(int[] nums, int k){
        int count = 0;
        for(int i = 0, j = 0; j<nums.length; j++){
            if((nums[j] & 1) == 1) k--;
            while(k<0){
                if((nums[i] & 1) == 1) k++;
                i++;
            }
            //total valid subarrays from index i till index j = j-i+1
            count += j-i+1;
        }
        return count;
    }
}
