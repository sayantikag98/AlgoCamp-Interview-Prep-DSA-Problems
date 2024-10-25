package SlidingWindowLeetcode;

//https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
        System.out.println(longestOnesMostOptimal(nums, k));
    }

    private static int longestOnesMostOptimal(int[] nums, int k) {
        //most optimal approach given in striver video
        //TC = O(n)
        //SC = O(1)

        int i = 0, j = 0, maxLen = 0;
        while(j<nums.length){
            if(nums[j] == 0){
                k--;
            }
            /*
            whenever the count of zero is greater than k then
            dont let the size of the window to shrink beyond the maxLen achieved so far because that wont lead to an answer
            so just increment the i pointer by one and make sure to reduce the count of zero if i before increment was pointing to zero
            */
            if(k < 0){
                if(nums[i] == 0) k++;
                i++;
            }
            //the window is invalid when the count is greater than k so dont update maxLen until the count of zero <= k
            if(k >= 0) maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }


    private static int longestOnes(int[] nums, int k) {
        //TC = O(n+n), SC = O(1)
        int i = 0, j = 0, maxLen = 0;
        while(j<nums.length){
            if(nums[j] == 0){
                k--;
            }
            if(k == -1){
                while(nums[i] == 1){
                    i++;
                }
                i++;
                k++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}
