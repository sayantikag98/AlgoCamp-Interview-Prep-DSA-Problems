package SearchingAndSorting.Searching;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 6;
        System.out.println(search(nums, target));
    }
    private static int search(int[] nums, int target) {
        //TC = O(log n), SC = O(1)
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] < nums[mid]){
                //mid is in the left sorted part of the sorted rotated array
                if(nums[low] <= target && target < nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[low]>nums[mid]){
                //mid is in the right region of the sorted rotated array
                if(nums[mid] < target && target <= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
             /*
            when nums[mid] == nums[low] then there are 2 elements then the nums[mid] has already been checked for target and we have to check the nums[high] element
            that is why low has to be moved to high so that there is only 1 element and that is also checked for target
            here high = mid-1 will be wrong because we will not be checking for the nums[high] element

            see test case nums=[2,1] target = 1
            */
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}
