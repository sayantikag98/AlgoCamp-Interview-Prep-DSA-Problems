package SlidingWindowLeetcode;
import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
    private static int subarraysWithKDistinct(int[] nums, int k) {
        //TC = O(2*2N), SC = O(2*k)
        // total no of subarrays with k different integers = total no of subarrays with <= k different integers - total
        // no of subarrays with <= k-1 different integers
        return countSubArray(nums, k) - countSubArray(nums, k-1);
    }

    private static int countSubArray(int[] nums, int k){
        int count = 0;
        HashMap<Integer, Integer> indFound = new HashMap<>();
        for(int i = 0, j = 0; j<nums.length; j++){
            indFound.put(nums[j], j);
            while(indFound.size()>k){
                if(indFound.get(nums[i]) == i){
                    indFound.remove(nums[i]);
                }
                i++;
            }
            count += j-i+1;
        }
        return count;
    }
}
