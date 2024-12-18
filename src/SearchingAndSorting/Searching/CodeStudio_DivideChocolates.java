package SearchingAndSorting.Searching;
import java.util.*;

//https://www.naukri.com/code360/problems/divide-chocolates_1466966
public class CodeStudio_DivideChocolates {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(5, 6, 7, 8, 9, 10, 11, 12, 13));
        int k = 3;
        System.out.println(getMaximumSweetness(arr, k));
    }

    private static int getMaximumSweetness(ArrayList<Integer> arr, int k) {
        //TC = O(n+n*log(sum of arr-min of arr)), SC = O(1)
        int[] getMinSum = getSumAndMin(arr);
        int low = getMinSum[0];
        int high = getMinSum[1];
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isValid(arr, k, mid)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    private static boolean isValid(ArrayList<Integer> arr, int k, int minTotalSweetness){
        int friends = 0;
        int sum = 0;
        for(int ele: arr){
            sum += ele;
            if(sum >= minTotalSweetness){
                friends++;
                sum = 0;
            }
        }
        return friends >= k+1;
    }

    private static int[] getSumAndMin(ArrayList<Integer> arr){
        int min = 10000, sum = 0;
        for(int ele: arr){
            min = Math.min(min, ele);
            sum += ele;
        }
        return new int[]{min, sum};
    }
}
