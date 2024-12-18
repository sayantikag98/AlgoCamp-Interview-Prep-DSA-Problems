package SearchingAndSorting.Searching;

//https://leetcode.com/problems/missing-element-in-sorted-array/description/
public class FindMissingElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 3;
        System.out.println(findMissing(nums, k));
    }

    private static int findMissing(int[] nums, int k){
        if(k == 0) return -1; //not necessary because of constraint given
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] - nums[0] - mid >= k){
                //go left
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        int pendingMissing = nums[high]-nums[0]-high;
        k-=pendingMissing;
        return nums[high]+k;
    }
}
