package TwoPointers;
import java.util.*;

//https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
public class KdiffPairsInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,3,1,5,4};
        int k = 0;
        System.out.println(findPairsUsingTwoPointers(nums, k));
        System.out.println(findPairsUsingHashmap(nums, k));
        System.out.println(findPairsUsingHashmapAnother(nums, k));
    }
    private static int findPairsUsingHashmap(int[] nums, int k) {
        //TC = O(n), SC = O(n)
        //similar to two sum
        //|a-b| = k means a+k = b and a-k=b except for k=0 where both a+k=a-k
        /*
        ******* k = 0 is an edge case here *****
        a-k = b so a=b
        */
        HashMap<Integer, Integer> isFound = new HashMap<>();
        int count = 0;
        for(int ele: nums){
            //for unique pair, for k = 0 frequency for key should be 1 and for k != 0 key should not be present
            if((k == 0 && isFound.getOrDefault(ele, 0) == 1) || (k != 0 && isFound.getOrDefault(ele, 0) == 0)){
                //both should not execute for k = 0
                if(isFound.containsKey(ele + k)) count++;
                if(k != 0 && isFound.containsKey(ele - k)) count++;
            }
            isFound.put(ele, isFound.getOrDefault(ele, 0)+1);
        }
        return count;
    }

    private static int findPairsUsingHashmapAnother(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int ele: nums){
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
        }

        int count = 0;
        for(int key: freq.keySet()){
            if((k>0 && freq.containsKey(key+k)) || (k==0 && freq.get(key) > 1)) {
                count++;
            }
        }

        return count;
    }

    private static int findPairsUsingTwoPointers(int[] nums, int k) {
        //two pointers
        //TC = O(nlogn), SC = O(1)
        int n = nums.length;
        if(n == 1) return 0;
        Arrays.sort(nums);
        int l = 0, r = 1, count = 0;
        while(r<n){
            if(nums[r] - nums[l] < k) r++;
            else if(nums[r] - nums[l] > k) l++;
            else{
                if(r!=l) count++;
                //only for k = 0
                if(l==r && r+1<n && nums[r+1] == nums[l]) count++;
                //for finding unique pairs
                while(r+1<n && nums[r] == nums[r+1]) r++;
                r++;
            }
        }
        return count;
    }
}
