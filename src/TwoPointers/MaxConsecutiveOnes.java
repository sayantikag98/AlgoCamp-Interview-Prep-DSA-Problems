package TwoPointers;

//https://leetcode.com/problems/max-consecutive-ones/description/
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, l = 0, n = nums.length;
        for(int r = 0; r<n; r++){
            if(nums[r] == 0){
                maxCount = Math.max(maxCount, r-l);
                l=r+1;
            }
        }
        return Math.max(maxCount, n-l);
    }
}
