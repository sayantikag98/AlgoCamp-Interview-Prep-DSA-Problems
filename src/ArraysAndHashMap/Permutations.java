package ArraysAndHashMap;
import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/permutations/
public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>> ans = permute(new int[]{1,2,3});
        System.out.println(ans);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lans = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i : nums){
            ans.add(i);
        }
        permutation(ans, 0, lans);
        return lans;
    }

    private static void permutation(List<Integer> nums, int i, List<List<Integer>> lans){
        if(i == nums.size()){
            lans.add(new ArrayList<>(nums));
            return;
        }
        for(int j = i; j<nums.size(); j++){
            swap(nums, i, j);
            permutation(nums, i+1, lans);
            swap(nums, i, j);
        }
    }

    private static void swap(List<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
