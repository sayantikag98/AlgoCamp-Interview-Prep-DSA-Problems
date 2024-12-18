package SearchingAndSorting.Searching;

//https://leetcode.com/problems/sqrtx/
public class FindNearestSquareRoot {
    public static void main(String[] args) {
        System.out.println(mySqrtUsingBinarySearch(11));
        System.out.println(mySqrtUsingLinearSearch(11));
    }
    private static int mySqrtUsingBinarySearch(int x) {
        //TC = O(log x), SC = O(1)
        //ans*ans <= x

        //defining the search space
        //sqrt x will be in [0, x]
        //sqrt x will definitely be there so ans can be initialized with anything
        int low = 0, high = x, ans = high;
        while(low<=high){
            int mid = low + (high - low)/2;
            //MAKE MISTAKE HERE
            long midSquare = (long)mid*mid;
            if(midSquare == x){
                //there is no better ans than mid
                ans = mid;
                break;
            }
            else if(midSquare < x){
                //mid could be a probable answer but we should see if there is a better answer more than this mid
                ans = mid;
                //discard the left half, search in the right half
                low = mid+1;
            }
            else{
                //when mid * mid > x then any number > mid will definitely not be my answer so discard the right half, search in the left half
                high = mid-1;
            }
        }
        return ans;
    }

    private static int mySqrtUsingLinearSearch(int x) {
        //TC = O(sqrt x), SC = O(1)
        int ans = 0;
        for(int i = 1; i<=x; i++){
            if((long) i * i <= x){
                ans = i;
            }
            else break;
        }
        return ans;
    }
}
