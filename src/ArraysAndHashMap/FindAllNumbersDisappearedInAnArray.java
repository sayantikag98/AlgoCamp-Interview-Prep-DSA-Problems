package ArraysAndHashMap;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDisappearedNumbersUsingCyclicSort(nums);
        System.out.println(ans);
        ans = findDisappearedNumbersUsingNegatingIndexValues(nums);
        System.out.println(ans);
    }

    private static List<Integer> findDisappearedNumbersUsingNegatingIndexValues(int[] nums) {
        //TC = O(n), SC = O(1)
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int idx = Math.abs(nums[i])-1;
            nums[idx] = Math.abs(nums[idx]) * -1;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(nums[i]>0) ans.add(i+1);
        }
        return ans;
    }
    private static List<Integer> findDisappearedNumbersUsingCyclicSort(int[] nums) {
        //TC = O(n), SC = O(1)
        int n = nums.length;
        for(int i = 0; i<n; i++){
            while(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i]-1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(nums[i] != i+1) ans.add(i+1);
        }
        return ans;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
