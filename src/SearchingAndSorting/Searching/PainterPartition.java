package SearchingAndSorting.Searching;

public class PainterPartition {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {40, 10, 30, 20};
        int k = 2;

        System.out.println(painterPartition(arr, n, k));
    }

    private static int getSum(int[] arr, int n){
        int sum = 0;
        for(var ele: arr){
            sum += ele;
        }
        return sum;
    }

    private static int painterPartition(int[] arr, int n, int k){
        //partition your array into subarray such that maximum sum of any subarray is minimum


        //similar to chocolate distribution problem
        //when k = 1 then the time taken would be sum of all elements and that is the upper bound
        //max element is the lower bound


        // sort the array if not sorted


        int low = arr[arr.length-1], high = getSum(arr, n), ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isValid(arr, n, k, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int n, int k, int time){
        //determine if it is possible to divide the arr into subarrays such that the maximum sum of any subarray is time
        // that is no sum of any subarray is greater than time
        int painters = 1, sum = 0;
        for(var ele: arr){
            if(ele > time) return false; //made mistake here
            sum += ele;
            if(sum > time){
                sum = ele;
                painters++;
                if(painters > k) return false;
            }
        }
        return true;
    }
}
