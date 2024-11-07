package TwoPointers;
import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {5,1,1};
        nextPermutation(nums);
        for(int ele: nums){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    private static void nextPermutation(int[] nums) {
        //TC = O(n), SC = O(1)
        int i, j, n = nums.length;
        //first breakpoint (index) of the increasing sequence from right
        for(i = n-2; i>=0; i--){
            if(nums[i]<nums[i+1]) break;
        }
        if(i != -1) {
            //find the index of the number just greater than the breakpoint element
            for(j = i+1; j<n; j++){
                if(nums[j]<=nums[i]) break;
            }
            j--;
            //swap nums[i] & nums[j]
            swap(nums, i, j);
        }
        //either sort or reverse the region from i+1 to end
        //reverse is a better option because the region is sorted in decreasing order so reverse Time Complexity O(n) better than O(nlogn) sort complexity
        // Arrays.sort(nums, i+1, n);
        i++;
        j = n-1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
