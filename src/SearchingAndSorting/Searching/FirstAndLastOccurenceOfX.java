package SearchingAndSorting.Searching;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastOccurenceOfX {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7,7,8,8,10};
        int x = 7;
        System.out.println(firstOccurrence(arr, x));
        System.out.println(lastOccurrence(arr, x));
        int[] ans = firstAndLastOccurrenceUsingLinearSearch(arr, x);
        for(var ele: ans){
            System.out.print(ele + " ");
        }
        System.out.println();
        ans = searchRangeUsingLowerAndUpperBound(arr, x);
        for(var ele: ans){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    private static int[] searchRangeUsingLowerAndUpperBound(int[] arr, int x) {
        //TC = O(n), SC = O(1)

        int[] ans = {-1, -1};
        int lb = lowerBound(arr, x);
        if(lb != arr.length && arr[lb] == x){
            ans[0] = lb;
            ans[1] = upperBound(arr, x)-1;
        }
        return ans;
    }

    private static int lowerBound(int[] arr, int x){
        //TC = O(log n), SC = O(1)
        int n = arr.length, low = 0, high = n-1, ans = n;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(x <= arr[mid]){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] arr, int x){
        int n = arr.length, low = 0, high = n-1, ans = n;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(x < arr[mid]){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }


    private static int[] firstAndLastOccurrenceUsingLinearSearch(int[] arr, int x){
        //TC = O(n), SC = O(1)
        int[] ans = {-1, -1};
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == x){
                if(ans[0] == -1){
                    //this is my first occurrence for sure
                    ans[0] = i;
                }
                ans[1] = i;
            }
        }
        return ans;
    }
    
    private static int firstOccurrence(int[] arr, int x){
        //TC = O(log n), SC = O(1)
        int low = 0, high = arr.length-1, ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(x <= arr[mid]){
                if(x == arr[mid]) ans = mid; //ans might be a possible answer
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static int lastOccurrence(int[] arr, int x){
        //TC = O(log n), SC = O(1)
        int low = 0, high = arr.length-1, ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] <= x){
                if(x == arr[mid]) ans = mid; //ans might be a possible answer
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}
