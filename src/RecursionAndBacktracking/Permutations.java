package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/permutations/
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lans = new ArrayList<>();
//        helper(nums, 0, 0, lans);
        helper(nums, 0, new HashSet<>(), new ArrayList<>(), lans);
        return lans;
    }

    private static void helper(int[] nums, int j, HashSet<Integer> hs, List<Integer> ans, List<List<Integer>> lans){
        if(j == nums.length){
            lans.add(new ArrayList<>(ans));
            return;
        }

        for(int ele: nums){
            if(hs.contains(ele)) continue;
            ans.add(ele);
            hs.add(ele);
            helper(nums, j+1, hs, ans, lans);
            hs.remove(ele);
            ans.removeLast();
        }
    }

    private static void helper(int[] nums, int start, int j, List<List<Integer>> lans){
        //TC = O(n*n!), SC = O(n*n!)
        if(j == nums.length){
            List<Integer> ans = new ArrayList<>();
            for(int ele: nums){
                ans.add(ele);
            }
            lans.add(ans);
            return;
        }
        for(int i = start; i<nums.length; i++){
            swap(nums, i, j);
            helper(nums, start+1, j+1, lans);
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
