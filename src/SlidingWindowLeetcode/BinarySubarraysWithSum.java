package SlidingWindowLeetcode;
import java.util.HashMap;

//https://leetcode.com/problems/binary-subarrays-with-sum/
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0,1,1,0,1,0,1,0};
        int goal = 2;
        System.out.println(numSubarraysWithSumMostOptimizedWithSlidingWindow(nums, goal));
        System.out.println(numSubarraysWithSumWithHashMap(nums, goal));
    }

    private static int numSubarraysWithSumMostOptimizedWithSlidingWindow(int[] nums, int goal) {
        //This problem could be optimized further in terms of space by not needing a hashmap and using sliding
        // window because the array have only 0 and 1 and no negatives
        //TC = O(2*2N), SC = O(1)
        /*
        count the total no of subarrays with sum as goal =
        count the total no of subarrays with sum <= goal - count the total no of subarrays with sum < goal
        */
        int countSubArrayWithSumLessEqGoal = countSubArrays(nums, goal);
        if(goal == 0) return countSubArrayWithSumLessEqGoal;
        int countSubArrayWithSumLessGoalMinusOne = countSubArrays(nums, goal-1);
        return countSubArrayWithSumLessEqGoal - countSubArrayWithSumLessGoalMinusOne;
    }

    private static int countSubArrays(int[] nums, int goal){
        int count = 0, sum = 0;
        for(int i = 0, j = 0; j<nums.length; j++){
            sum += nums[j];
            while(sum > goal){
                sum -= nums[i];
                i++;
            }
            count += j-i+1;
        }
        return count;
    }
    private static int numSubarraysWithSumWithHashMap(int[] nums, int goal) {
        //SAME SOLUTION AS FOR LEETCODE 560. Subarray Sum Equals K
        //https://leetcode.com/problems/subarray-sum-equals-k/description/
        //TC = O(n), SC = O(n)
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(nums[0], 1);
        for(int j = 1; j<nums.length; j++){
            nums[j]+=nums[j-1];
            count+=freq.getOrDefault(nums[j]-goal, 0);
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
        }
        return count + freq.getOrDefault(goal, 0);
    }
}
