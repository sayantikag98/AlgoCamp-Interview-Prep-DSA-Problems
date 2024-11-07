package TwoPointers;
import java.util.*;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        List<List<Integer>> lans = threeSumUsingBinarySearch(nums);
        System.out.println(lans);
        lans = threeSumMoreOptimized(nums);
        System.out.println(lans);
    }
    private static List<List<Integer>> threeSumMoreOptimized(int[] nums) {
        //TC = O(n^2), SC = O(1)
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lans = new ArrayList<>();
        for(int i = 0; i<n-2; i++){
            //to maintain unique triplets
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k] == 0){
                    lans.add(List.of(nums[i], nums[j], nums[k]));
                    //don't stop at this there might be more pairs so increment j till you find a different nums[j] or can also decrement k till a different nums[k] or move both k and j
                    k--;
                    //to maintain unique triplets
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
                else if(nums[i]+nums[j]+nums[k] > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return lans;
    }

    private static List<List<Integer>> threeSumUsingBinarySearch(int[] nums) {
        //TC = O(n^2*logn), SC = (1)
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lans = new ArrayList<>();
        for(int i = 0; i<n-2; i++){
            //to maintain unique triplets
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<n; j++){
                if(j!=i+1 && nums[j] == nums[j-1]) continue;
                int target = - nums[i] - nums[j];
                //public static int binarySearch(int[] a, int fromIndex, int toIndex, int key)
                int ind = Arrays.binarySearch(nums, j+1, n, target);
                if(ind >= 0){
                    lans.add(List.of(nums[i], nums[j], target));
                }
            }
        }
        return lans;
    }
}
