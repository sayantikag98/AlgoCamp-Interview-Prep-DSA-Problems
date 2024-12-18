package SearchingAndSorting.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7};
        int target = 7;
        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearchRecursive(arr, 0, arr.length-1, target));
    }
    private static int binarySearch(int[] arr, int target){
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int low, int high, int target){
        if(low>high) return -1;
        int mid = low + (high - low)/2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] < target){
            return binarySearchRecursive(arr, mid+1, high, target);
        }
        return binarySearchRecursive(arr, low, mid-1, target);
    }

}
