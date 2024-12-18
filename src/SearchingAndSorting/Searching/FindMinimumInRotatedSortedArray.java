package SearchingAndSorting.Searching;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findMin(nums));
        System.out.println(findMinMoreCompactImplementation(nums));
    }

    //In a sorted rotated array arr[0] > arr[n-1] and in a sorted array arr[0] < arr[n-1]
    private static int findMinMoreCompactImplementation(int[] nums) {
        int low = 0, high = nums.length-1, ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[low]>nums[high] && nums[high] < nums[mid]){
                low = mid+1;
            }
            else{
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }

    private static int findMin(int[] nums) {
        int low = 0, high = nums.length-1, ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high - low)/2;
            ans = Math.min(ans, nums[mid]);
            if(nums[low]>nums[high]){
                if(nums[mid] < nums[high]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}
