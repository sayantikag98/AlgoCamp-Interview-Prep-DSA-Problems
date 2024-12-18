package SearchingAndSorting.Sorting;

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = {3,23,12,4678,23,455432,1};
        radixSort(nums);
        for(var ele: nums){
            System.out.print(ele+ " ");
        }
        System.out.println();
    }

    private static void radixSort(int[] nums){
        //to get the total iterations of radix sort => total digits of maximum element
        int maxEle = Integer.MIN_VALUE;
        for(var ele: nums){
            maxEle = Math.max(maxEle, ele);
        }

        //iterate till all digits explored
        int place = 1, n = nums.length;
        while(maxEle != 0){
            countSort(nums, place, n);
            maxEle/=10;
            place *= 10;
        }
    }

    private static void countSort(int[] nums, int place, int n){
        int[] freq = new int[10]; //digits can be from 0 to 9 only

        //to get the frequency of digit
        for(var ele: nums){
            int digit = ele/place % 10; // 3456 => to get the tenth digit => 3456/10 = 345%10 = 5
            freq[digit]++;
        }

        //cumulative frequency
        for(int i = 1; i<10; i++){
            freq[i] += freq[i-1];
        }

        //to get the correct position of the element from freq array
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            int digit = nums[i]/place % 10;
            ans[--freq[digit]] = nums[i];
        }

        //copy back to original array
        System.arraycopy(ans, 0, nums, 0, n);
    }
}
