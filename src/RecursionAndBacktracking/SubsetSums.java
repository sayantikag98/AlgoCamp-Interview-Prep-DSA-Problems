package RecursionAndBacktracking;
import java.util.*;

public class SubsetSums {
    public static void main(String[] args) {
        List<Integer> arr = List.of(10,6,4,2);
        System.out.println(subsetSums(arr, arr.size()));

    }
    private static ArrayList<Integer> subsetSums(List<Integer> arr, int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        helper(arr, n, 0, 0, ans);
        return ans;

    }

    private static void helper(List<Integer> arr, int n, int i, int sum, ArrayList<Integer> ans){
        if(i == n){
            ans.add(sum);
            return;
        }
        helper(arr, n, i+1, sum, ans);
        helper(arr, n, i+1, sum + arr.get(i), ans);
    }
}
