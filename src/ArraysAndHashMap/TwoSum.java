package ArraysAndHashMap;
import java.util.Arrays;
import java.util.HashMap;
//https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSumOnePass(nums,target)));
        System.out.println(Arrays.toString(twoSumTwoPass(nums,target)));
    }

    private static int[] twoSumOnePass(int[] nums, int target) {
        //TC = O(n), SC = O(n)
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<n; i++){
            int val = target - nums[i];
            if(hm.containsKey(val)){
                return new int[]{hm.get(val), i};
            }
            hm.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumTwoPass(int[] nums, int target) {
        //TC = O(n), SC = O(n)
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = n-1; i>=0; i--){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], i);
            }
        }
        for(int i = 0; i<n; i++){
            int val = target - nums[i];
            if(hm.containsKey(val) && hm.get(val) != i){
                return new int[]{i, hm.get(val)};
            }
        }
        return new int[]{-1, -1};
    }
}
