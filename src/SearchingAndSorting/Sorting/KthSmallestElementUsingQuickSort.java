package SearchingAndSorting.Sorting;
import java.util.*;

public class KthSmallestElementUsingQuickSort {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int index = quickSort(nums, 0, nums.length-1, 5);
        System.out.println(index == -1 ? -1 : nums[index]);
    }

    private static int quickSort(int[] nums, int l, int r, int k){
        if(k < 1 || k > nums.length) return -1;
        /*
        Quickselect is a selection algorithm to find the k-th smallest element in an unordered
        list. It is related to the quick sort sorting algorithm.
         */
        //TC = theta(n), SC = theta(log n)
        if(l>r) return -1;
        if(l==r){
            return l;
        }
        Random rand = new Random();
        int pivotIdx = rand.nextInt(l, r+1);
        //partitionIndex will define the element at partitionIndex is at its correct place
        int partitionIdx = partition(nums, l, r, nums[pivotIdx]);
        int index;
        if(partitionIdx == k-1) {
            index = k-1;
        }
        ///******* DO NOT MODIFY K FOR ANY RECURSIVE CALL ***********
        /*
        because partition index will always be calculated from 0th index
         */
        else if(partitionIdx < k-1){
            //now the subarray becomes partitionIdx+1 till r so map k accordingly
            index = quickSort(nums, partitionIdx+1, r, k);
        }
        else{
            index = quickSort(nums, l, partitionIdx-1, k);
        }
        return index;
    }

    private static int partition(int[] nums, int l, int r, int pivot){
        /*
        here you pass the pivot can't compute pivot index here because l points to 5 and r point to 3 and 3 is my pivot then you will swap 3 & 5 then pivot index changed
         */
        int pivotIdx = -1;
        while(l != r){
            if(nums[l]>pivot){
                //swap nums[l] & nums[r]
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            }
            else{
                if(nums[l] == pivot) pivotIdx = l;
                l++;
            }
        }
        if(nums[l]>pivot) l--;
        if(nums[l]<pivot){
            //swap nums[l] & nums[pivotIdx]
            nums[pivotIdx] = nums[l];
            nums[l] = pivot;
        }
        return l;
    }
}
