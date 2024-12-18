package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), lans);
        return lans;
    }

    private static void helper(int[] nums, int target, int i, List<Integer> ans, List<List<Integer>> lans){
        /*
        Time Complexity Analysis

            Your implementation of the Combination Sum problem uses a backtracking approach. Let's analyze the time complexity of this code.

            Code Analysis:

            The function helper recursively explores two choices at every step:
                Include the current element (nums[i]).
                Exclude the current element and move to the next (i + 1).
            The inclusion choice allows repeated use of the same element (helper(nums, target - nums[i], i, ans, lans)).
            When target is reduced to zero, a valid combination is found, and it's added to the result list.

        Time Complexity:

            Number of choices: At each index i, we have 2 choices — either include nums[i] or exclude it and move to the next index.
            Tree Height: The maximum depth of the recursion tree is at most target / min(candidates). This is because the smallest element in the array would be repeatedly subtracted from the target until it reaches 0.

        Let's break it down:

        Worst-case scenario:
            In the worst case, at each recursive step, we can decide to include or exclude the current number. This would lead to an exponential number of recursive calls, similar to O(2^n) where n is the number of elements in candidates.

        Pruning the search space:
            The recursion does pruning when target < 0, and thus not all paths are explored fully. However, this pruning does not significantly reduce the upper bound in the worst-case scenario, especially when there are many combinations.

        Total number of combinations:
            Each combination in the result is a sequence where the sum of elements equals target. The number of combinations could be exponential in relation to the target, specifically O(2^(target / min(candidates))).

        Overall Time Complexity:
            The time complexity is typically analyzed as: O(2^(target / min(candidates)) * n)

            O(2^(target / min(candidates))): Represents the maximum number of recursive calls, as we could explore all possible combinations of including or excluding elements.
            O(n): The additional cost of copying the current list of elements (ans) to the final answer list.

        Space Complexity:

            Recursive Stack Space: The maximum depth of recursion is O(target / min(candidates)).
            Auxiliary Space: Storing each valid combination could take up to O(n) space, where n is the maximum length of the valid combination.

        Thus, the space complexity is:

            O(target / min(candidates))

        In conclusion, the time complexity is exponential, driven by the number of combinations that can be formed and the depth of recursive calls.
         */
        if(target <= 0){
            if(target == 0){
                lans.add(new ArrayList<>(ans));
            }
            return;
        }
        if(i == nums.length) return;

        //approach: add in the same element till the sum >= target and then move to the next element
        //PICK AND NOT PICK STRATEGY
        //every element has two options
        //1. add in the same element
        ans.add(nums[i]);
        helper(nums, target - nums[i], i, ans, lans);
        ans.removeLast();

        //2. don't add that element and move to the next element
        helper(nums, target, i+1, ans, lans);
    }
}
