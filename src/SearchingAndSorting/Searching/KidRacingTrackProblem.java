package SearchingAndSorting.Searching;

public class KidRacingTrackProblem {
    public static void main(String[] args) {
        int[] arr = {1,2,4,8,9};
        int kids = 3;
        System.out.println(maxDistance(arr, arr.length, kids));
    }
    private static int maxDistance(int[] arr, int n, int kids){
        //if array not sorted then sort it
        //TC = (n * log n)
        int low = 1, high = arr[arr.length-1]-arr[0], ans = low;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isValid(arr, mid, n, kids)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int minDist, int n, int kids){
        //to check if the minimum distance between any two kids is minDist possible or not
        int nKids = 1, lastPlaced = arr[0];
        for(int i = 1; i<n; i++){
            if(arr[i] - lastPlaced >= minDist){
                nKids++;
                lastPlaced = arr[i];
                if(nKids == kids) return true;
            }
        }
        return false;
    }
}
