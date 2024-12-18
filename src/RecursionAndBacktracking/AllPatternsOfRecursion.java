package RecursionAndBacktracking;
import java.util.*;

public class AllPatternsOfRecursion {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5,6};
        int k = 10;
        //print all possibilities
        printSubsequencesWithSumK(nums, 0, k, new ArrayList<>(), 0);
        //print any one possibility
        printSingleSubsequence(nums, 0, k, new ArrayList<>(), 0);
        //count all possibilities
        System.out.println(countAllSubSequencesWithSumK(nums, 0, k, 0));
    }

    private static void printSubsequencesWithSumK(int[] nums, int i, int k, List<Integer> ans, int sum){
        if(i == nums.length){
            if(sum == k){
                System.out.println(ans);
            }
            return;
        }
        ans.add(nums[i]);
        printSubsequencesWithSumK(nums, i+1, k, ans, sum + nums[i]);
        ans.removeLast();
        printSubsequencesWithSumK(nums, i+1, k, ans, sum);
    }

    private static boolean printSingleSubsequence(int[] nums, int i, int k, List<Integer> ans, int sum){
        if(i == nums.length){
            if(sum == k){
                System.out.println(ans);
                return true;
            }
            return false;
        }
        ans.add(nums[i]);
        boolean isFound = printSingleSubsequence(nums, i+1, k, ans, sum + nums[i]);
        if(isFound) return true;
        ans.removeLast();
        return printSingleSubsequence(nums, i+1, k, ans, sum);
    }

    private static int countAllSubSequencesWithSumK(int[] nums, int i, int k, int sum){
        if(i == nums.length){
            if(sum == k) return 1;
            return 0;
        }
        return countAllSubSequencesWithSumK(nums, i+1, k, sum+nums[i]) + countAllSubSequencesWithSumK(nums, i+1, k, sum);
    }
}
