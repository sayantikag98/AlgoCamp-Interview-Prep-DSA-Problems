package TwoPointers;
import java.util.HashMap;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,3}, nums2 = {2,2};
        int[] ans = intersection(nums1, nums2);
        for(int ele: ans){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    private static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> elePresent = new HashMap<>();
        for(int ele: nums1){
            elePresent.put(ele, false);
        }
        int size = 0;
        for(int ele: nums2){
            if(elePresent.containsKey(ele) && !elePresent.get(ele)){
                elePresent.put(ele, true);
                size++;
            }
        }

        int[] ans = new int[size];
        int k = 0;
        for(int key: elePresent.keySet()){
            if(elePresent.get(key)){
                ans[k++] = key;
            }
        }
        return ans;
    }
}
