package SearchingAndSorting.Searching;
import java.util.*;

public class BookAllocationProblem {
    public static void main(String[] args) {
        int n = 4, m = 2;
        /*
        Different ways to declare an arraylist and add elements in it
        1. ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        2. ArrayList<Integer> arr = new ArrayList<>() {{
                add(1);
                add(2);
                add(3);
            }};
        3. ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3));
         */
        ArrayList<Integer> arr = new ArrayList<>(List.of(12, 34, 67, 90));
        System.out.println(findPages(arr, n, m));
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        //same as chocolate distribution problem

        if(m > n) return -1; //five books cannot be allocated to six students

        //TC = O(n * log (sum of all elements of arr)), SC = O(1)

        //to get the lower bound of the maximum pages that can be allocated
        // lets say we consider this maximum pages be the second-largest element then the max page book cannot be allocated to any student which violates the constraint
        // of allocating all books so largest element can only be the lower bound
        int low = getMax(arr);

        //to get the upper bound take m = 1
        //then the maximum pages to allocate will be sum of all pages in arr

        int high = getSum(arr);
        int ans = -1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(isValid(arr, n, m, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isValid(ArrayList<Integer> arr, int n, int m, int maxPages){
        int students = 1, sum = 0;
        for(var pages: arr){
            if(pages > maxPages) return false;
            sum += pages;
            if(sum > maxPages){
                students++;
                sum = pages;
            }
        }
        return students <= m;
    }

    private static int getSum(ArrayList<Integer> arr){
        int sum = 0;
        for(var ele: arr){
            sum += ele;
        }
        return sum;
    }

    private static int getMax(ArrayList<Integer> arr){
        int max = arr.getFirst();
        for(int i = 1; i<arr.size(); i++){
            max = Math.max(max, arr.get(i));
        }
        return max;
    }
}
