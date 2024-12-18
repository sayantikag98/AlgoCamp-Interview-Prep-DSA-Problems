package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/subsets/description/
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lans = new ArrayList<>();
        helper2(nums, nums.length, 0, new ArrayList<>(), lans);
        return lans;
    }

    private static void helper2(int[] nums, int n, int start, List<Integer> ans, List<List<Integer>> lans){
        lans.add(new ArrayList<>(ans));

        for(int i = start; i<n; i++){
            ans.add(nums[i]);
            helper2(nums, n, i+1, ans, lans);
            ans.removeLast();
        }
    }

    private static void helper(int[] nums, int n, int i, List<Integer> ans, List<List<Integer>> lans){
        if(i == n){
            lans.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[i]);
        helper(nums, n, i+1, ans, lans);
        ans.removeLast();
        helper(nums, n, i+1, ans, lans);

    }


    /*
    nums = {1,2}
    pick 1 => 1 _
    pick 2 => 1 2 (bc)
    not pick 2 => 1 _ (bc)
    not pick 1 => _ _
    pick 2 => 2 _ (bc)
    not pick 2 => _ _ (bc)
    */
}
