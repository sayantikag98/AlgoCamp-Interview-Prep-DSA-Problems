package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        int[] nums = new int[n];
        System.arraycopy(candidates, 0, nums, 0, n);
        Arrays.sort(nums);
        List<List<Integer>> lans = new ArrayList<>();
        helper(nums, target, 0, new ArrayList<>(), lans);
        System.out.println(lans);
        lans.clear();
        helper2(nums, target, 0, new ArrayList<>(), lans);
        return lans;
    }

    private static void helper(int[] nums, int target, int i, List<Integer> ans, List<List<Integer>> lans){
        //TC = O(2^n * n), SC = O(n)
        if(target <= 0){
            if(target == 0){
                //valid combination
                lans.add(new ArrayList<>(ans));
            }
            return;
        }

        if(i == nums.length) return;

        ans.add(nums[i]);
        //pick nums[i]
        helper(nums, target - nums[i], i+1, ans, lans);
        ans.removeLast();
        //do not pick nums[i]
        //you need to make sure that when nums[i] is not picked, nums[i+1] should not be equal nums[i] otherwise proceed forward till nums[i] != nums[i+1] or i == n-1
        /*
        This step is important for getting all the unique combinations. Why?
        When nums[i] was included we have seen all the possibilities with nums[i], now when nums[i] was excluded and nums[i+1] = nums[i] then we are
        again making all the same recursion calls to check all possibilities with nums[i] which was not needed because we needed unique combinations
        so sort the array and move i till nums[i] != nums[i+1] or i = n-1 index
        */
        while(i<nums.length-1 && nums[i] == nums[i+1]){
            i++;
        }
        helper(nums, target, i+1, ans, lans);

    }

    private static void helper2(int[] nums, int target, int start, List<Integer> ans, List<List<Integer>> lans){
        //TC = O(2^n * n), SC = O(n)

        if(target == 0){
            //valid combination
            lans.add(new ArrayList<>(ans));
            return;
        }

        //either handle the repeated case like this
        // 1. if(i>start && nums[i] == nums[i-1]) continue;
        // or like this
        // 2. while(i<nums.length-1 && nums[i] == nums[i+1]) i++;

        for(int i = start; i<nums.length; i++){
            //repeated elements case handling
            if(i>start && nums[i] == nums[i-1]) continue;
            if(target > 0){
                ans.add(nums[i]);
                helper(nums, target - nums[i], i+1, ans, lans);
                ans.removeLast();
            }
        }

//        for(int i = start; i<nums.length; i++){
//            int prev = i;
//            //repeated elements case handling
//            while(i<nums.length-1 && nums[i] == nums[i+1]) i++;
//            if(target > 0){
//                ans.add(nums[i]);
//                helper(nums, target - nums[i], prev+1, ans, lans);
//                ans.removeLast();
//            }
//        }
    }
}
