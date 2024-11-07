package Recursion;

public class SearchAnElement {
    public static void main(String[] args) {
        int[] arr = {3,5,7,82,3,4,5,7,9};
        int target = 77;
        System.out.println(isPresent(arr, 0, target));
    }

    private static boolean isPresent(int[] arr, int i, int target){
        if(i == arr.length) return false;
        return arr[i] == target || isPresent(arr, i+1, target);
    }
}
