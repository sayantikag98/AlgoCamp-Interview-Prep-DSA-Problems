package SearchingAndSorting.Searching;

public class LowerBoundAndUpperBound {
    public static void main(String[] args) {
        int[] arr = {1,2,4,4,4,6,8};
        int x1 = 4, x2 = 5, x3 = 0, x4 = 10;
        System.out.println("The lower bound of "+x1+" is: "+lowerBound(arr, x1));
        System.out.println("The upper bound of "+x1+" is: "+upperBound(arr, x1));
        System.out.println("The lower bound of "+x2+" is: "+lowerBound(arr, x2));
        System.out.println("The upper bound of "+x2+" is: "+upperBound(arr, x2));
        System.out.println("The lower bound of "+x3+" is: "+lowerBound(arr, x3));
        System.out.println("The upper bound of "+x3+" is: "+upperBound(arr, x3));
        System.out.println("The lower bound of "+x4+" is: "+lowerBound(arr, x4));
        System.out.println("The upper bound of "+x4+" is: "+upperBound(arr, x4));
    }

    //if target is not present then lower bound of target will be equal to the upper bound of target
    //if target is present in the array then lower bound of target will be the first occurrence of target


    private static int lowerBound(int[] arr, int x){
        //first position of element >= target
        int low = 0, high = arr.length-1, ans = arr.length;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] < x){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] arr, int x){
        //first position of element > target
        int low = 0, high = arr.length-1, ans = arr.length;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] <= x){
                //go right
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}
