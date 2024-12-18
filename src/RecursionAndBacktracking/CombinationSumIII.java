package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lans = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), lans);
        return lans;
    }

    private static void helper(int k, int n, int start, List<Integer> ans, List<List<Integer>> lans){
        //TC = O(9Ck * k), SC = O(k)
        //for time complexity, total no of ways to pick k numbers from 1 to 9 is 9Ck, and multiplied by k because for every
        //valid combinations you are creating a new arraylist and copy elements from old list (ans)
        //SC = depth of the recursion tree which is k + ans list of k elements (not considering the final list lans)
        //depth of recursion = k and branches is 10 - start
        if(n <= 0){
            if(k == 0 && n == 0) lans.add(new ArrayList<>(ans));
            return;
        }

        if(k == 0) return;

        for(int j = start; j<10; j++){
            ans.add(j);
            helper(k - 1, n - j, j+1, ans, lans);
            ans.removeLast();
        }
    }
}
