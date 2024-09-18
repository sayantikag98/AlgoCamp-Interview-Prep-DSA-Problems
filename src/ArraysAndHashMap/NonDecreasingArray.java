package ArraysAndHashMap;
//https://leetcode.com/problems/non-decreasing-array/

public class NonDecreasingArray {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,1,5,8}));
    }

    private static boolean checkPossibility(int[] nums) {
        //TC = O(n), SC = O(1)
        int n = nums.length, count = 0;
        for(int i = 0; i<n-1; i++){
            if(nums[i]>nums[i+1]) {
                count++;
                if(count == 2 || (i>0 && i<n-2 && !(nums[i-1]<=nums[i+1] || nums[i]<=nums[i+2]))){
                    return false;
                }
            }
        }
        return true;
    }
}
