package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/permutations-ii/
public class PermutationsII_NotSolved {
    public static void main(String[] args) {
        int[] nums = {-1,2,0,-1,1,0,1};
        List<List<Integer>> lans = permuteUnique(nums);
        for(List<Integer> ans: lans){
            System.out.println(ans);
        }
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        int[] arr = new int [n];
        System.arraycopy(nums, 0, arr, 0, n);
        Arrays.sort(arr);
        List<List<Integer>> lans = new ArrayList<>();
        helper(arr, 0, new HashMap<>(), new ArrayList<>(), lans);
        return lans;
    }

    private static void helper(int[] nums, int j, HashMap<Integer, HashSet<Integer>> hm, List<Integer> ans, List<List<Integer>> lans){
        if(j == nums.length){
            lans.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            //you cannot place the same element at the same position
            HashSet<Integer> hs;
            if(hm.containsKey(nums[i])){
                hs = hm.get(nums[i]);
                if(hs.contains(j)) continue;
            }
            else{
                hs = new HashSet<>();
                hm.put(nums[i], hs);
            }
            ans.add(nums[i]);
            hs.add(j);
            helper(nums, j+1, hm, ans, lans);
            ans.removeLast();
            hs.remove(j);
        }
    }

    private static void helper(int[] nums, int start, int j, List<List<Integer>> lans){
        if(j == nums.length){
            List<Integer> ans = new ArrayList<>();
            for(int ele: nums){
                ans.add(ele);
            }
            lans.add(ans);
            return;
        }

        for(int i = start; i<nums.length; i++){
            if(i == j || (nums[i] != nums[j] && nums[i] != nums[i-1])){
                if(nums[i] != nums[j]) swap(nums, i, j);
                helper(nums, start+1, j+1, lans);
                if(nums[i] != nums[j]) swap(nums, i, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
