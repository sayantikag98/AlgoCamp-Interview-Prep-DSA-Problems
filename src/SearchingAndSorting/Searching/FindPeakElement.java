package SearchingAndSorting.Searching;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }

    private static int findPeakElement(int[] arr){
        int low = 0, high = arr.length-1;
        while(low <= high){
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
