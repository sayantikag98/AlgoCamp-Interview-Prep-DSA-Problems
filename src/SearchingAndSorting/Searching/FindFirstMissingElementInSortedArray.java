package SearchingAndSorting.Searching;

public class FindFirstMissingElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,6,7,8,9,10};
        System.out.println(findMissing(arr));
    }
    private static int findMissing(int[] arr){
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[0] + mid == arr[mid]){
                //move right
                low = mid+1;
            }
            else{
                //move left
                high = mid-1;
            }
        }
        return arr[high]+1;
    }

    //2 3 4
}
