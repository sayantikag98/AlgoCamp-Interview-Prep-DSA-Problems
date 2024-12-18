package RecursionAndBacktracking;

public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = {3,2,4,6,2,1};
        System.out.println(arraySum(arr, 0, arr.length));
    }

    private static int arraySum(int[] arr, int i, int n){
        if(i == n) return 0;
        return arr[i] + arraySum(arr, i+1, n);
    }
}
