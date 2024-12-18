package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/combinations/description/
public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lans = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), lans);
        return lans;
    }

    private static void helper(int n, int k, int start, List<Integer> ans, List<List<Integer>> lans){
        //TC = O(nCk * k), SC = O(k)
        //for time complexity, total no of ways to pick k numbers from 1 to n is nCk, and multiplied by k because for every
        //valid combinations you are creating a new arraylist and copy k elements from old list (ans)
        //SC = depth of the recursion tree which is k + ans list of k elements (not considering the final list lans)
        //depth of recursion = k and branches is n + 1 - start
        if(k == 0){
            lans.add(new ArrayList<>(ans));
            return;
        }

        for(int i = start; i<=n; i++){
            ans.add(i);
            helper(n, k-1, i+1, ans, lans);
            ans.removeLast();
        }
    }
}
