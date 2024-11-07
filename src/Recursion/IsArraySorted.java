package Recursion;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,6};
        System.out.println(isArraySorted(arr, 0));
    }

    private static boolean isArraySorted(int[] arr, int i){
        if(i >= arr.length-1) return true; //empty array is sorted
        return arr[i] <= arr[i+1] && isArraySorted(arr, i+1);
    }
}
