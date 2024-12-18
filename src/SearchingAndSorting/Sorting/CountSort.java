package SearchingAndSorting.Sorting;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {3,1,1,3,4,2,5};
        countSort(nums);
        for(var ele: nums){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    private static void countSort(int[] arr){
        int maxElement = Integer.MIN_VALUE;

        for(var ele: arr){
            maxElement = Math.max(maxElement, ele);
        }

        int[] freq = new int[maxElement];

        for(var ele: arr){
            freq[ele-1]++;
        }

        for(int i = 1; i<freq.length; i++){
            freq[i] += freq[i-1];
        }

        int[] ans = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--){
            ans[--freq[arr[i]-1]] = arr[i];
        }

        System.arraycopy(ans, 0, arr, 0, arr.length);
    }
}
