package SearchingAndSorting.Searching;

//https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(singleNonDuplicate(nums));
    }

    private static int singleNonDuplicate(int[] nums) {
        //any half having single element will have odd length only
        //always move to that half which has the odd length
        int low = 0, high = nums.length-1;
        while(low<high){
            int mid = low + (high - low)/2;
            if(mid > low && mid < high && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            int n = high - low + 1;
            if(((n/2) & 1) == 0){
                //even length half
                if(nums[mid] == nums[mid-1]){
                    //mid's partner to the left
                    high = mid-2;
                }
                else if(nums[mid] == nums[mid+1]){
                    //mid's partner to the right
                    low = mid+2;
                }
            }
            else{
                //odd length half
                if(nums[mid] == nums[mid-1]){
                    //mid's partner to the left
                    low = mid+1;
                }
                else if(nums[mid] == nums[mid+1]){
                    //mid's partner to the right
                    high = mid-1;
                }
            }

        }
        return nums[low];
    }
}
