package SearchingAndSorting.Sorting;
import java.util.*;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
    private static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length-1);
    }

    private static int quickSort(int[] nums, int k, int l, int r){
        if(l == r){
            return nums[l];
        }
        Random rand = new Random();
        int pivot = nums[rand.nextInt(l, r+1)];
        int partitionIndex = partition(nums, l, r, pivot);
        if(partitionIndex == k-1) return nums[k-1];
        else if(partitionIndex > k-1){
            return quickSort(nums, k, l, partitionIndex-1);
        }
        return quickSort(nums, k, partitionIndex+1, r);
    }

    private static int partition(int[] nums, int l, int r, int pivot){
        //right to r -> smaller than pivot elements
        //left to l -> large
        int pivotIdx = -1;
        while(l!=r){
            if(nums[l]>=pivot){
                if(nums[l] == pivot) pivotIdx = l;
                l++;
            }
            else{
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                r--;
            }
        }

        if(nums[l]<pivot) l--;
        if(nums[l]>pivot){
            nums[pivotIdx] = nums[l];
            nums[l] = pivot;
        }
        return l;
    }
}
