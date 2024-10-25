package ArraysAndHashMap;
import java.util.HashMap;

//https://leetcode.com/problems/subarray-sum-equals-k/

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{5,0,-6,1,2,-4,6,9,-10}, -1));
        System.out.println(subarraySumOnePass(new int[]{5,0,-6,1,2,-4,6,9,-10}, -1));
    }

    private static int subarraySumOnePass(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int ele: nums){
            sum += ele;
            int target = sum - k;
            if(hm.containsKey(target)){
                count+=hm.get(target);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return count + hm.getOrDefault(k, 0);
    }

    private static int subarraySum(int[] nums, int k) {
        //TC = O(n), SC = O(n)
        int n = nums.length;
        for(int i = 1; i<n; i++){
            nums[i] += nums[i-1];
        }

        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int ele: nums){
            int target = ele - k;
            if(hm.containsKey(target)){
                count+=hm.get(target);
            }
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }

        return count + hm.getOrDefault(k, 0);
    }
}
