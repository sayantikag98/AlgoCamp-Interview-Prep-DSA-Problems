package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/subsets-ii/description/
public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        System.arraycopy(nums, 0, arr, 0, n);
        Arrays.sort(arr);
        List<List<Integer>> lans = new ArrayList<>();
        helper(arr, n, 0, new ArrayList<>(), lans);
        return lans;
    }

    private static void helper(int[] nums, int n, int i, List<Integer> ans, List<List<Integer>> lans){
        //similar to combination sum II
        //TC = O(n*(2^n)), SC = O(n)
        /*
       Overall Time Complexity: O(n * 2^n)
            2^n for generating all possible subsets.
            O(n) for copying subsets into the result list at each call.
        Overall Space Complexity: O(n * 2^n)
            O(n) for the call stack depth.
            O(n) for the temporary list ans.
            Thus, the auxiliary space complexity is O(n).
            However, including the space for the output list (lans), the total space complexity becomes O(n * 2^n).
         */
        if(i == n){
            lans.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[i]);
        helper(nums, n, i+1, ans, lans);
        ans.removeLast();
        while(i<n-1 && nums[i] == nums[i+1]) i++;
        helper(nums, n, i+1, ans, lans);

    }
}
