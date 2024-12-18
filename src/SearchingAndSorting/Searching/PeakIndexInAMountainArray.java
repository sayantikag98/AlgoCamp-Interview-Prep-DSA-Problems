package SearchingAndSorting.Searching;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{1,3,5,6,7,-1}));
    }
    private static int peakIndexInMountainArray(int[] arr) {
        int low = 1, high = arr.length-2;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            if(arr[mid]>arr[mid-1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

    private static int peakIndexInMountainArray1(int[] arr){
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(mid == 0 || arr[mid-1] < arr[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }
}
