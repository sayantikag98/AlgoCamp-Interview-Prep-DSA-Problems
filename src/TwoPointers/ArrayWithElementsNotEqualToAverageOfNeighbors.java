package TwoPointers;
import java.util.*;

//https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/description/
public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] ans = rearrangeArrayUsingSorting(nums);
        System.out.println(Arrays.toString(ans));
        ans = rearrangeArrayWithoutSorting(nums);
        System.out.println(Arrays.toString(ans));
    }
    private static int[] rearrangeArrayUsingSorting(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        System.arraycopy(nums, 0, ans, 0, n);
        Arrays.sort(ans);
        int i = 1;
        while(i<n-1){
            int temp = ans[i];
            ans[i] = ans[i+1];
            ans[i+1] = temp;
            i+=2;
        }
        return ans;
    }
    private static int[] rearrangeArrayWithoutSorting(int[] nums) {
        // Arrays.sort(nums);
        for(int i = 1; i<nums.length-1; i++){
            if(Math.abs(nums[i]-nums[i-1]) == Math.abs(nums[i]-nums[i+1])){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        for(int i = nums.length-2; i>0; i--){
            if(Math.abs(nums[i]-nums[i-1]) == Math.abs(nums[i]-nums[i+1])){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        return nums;
    }
}
