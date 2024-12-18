package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition1("aab"));
    }

    private static List<List<String>> partition1(String s) {
        List<List<String>> lans = new ArrayList<>();
        helper1(s, 0, 0, new ArrayList<>(), lans);
        return lans;
    }

    /*
    place the first partition anywhere from 0 to n-1, once the first partition is placed, place the second and so on
    second partition will start from the position of first partition + 1 and this can also go uptil n-1 position
    after placing a partition check if the substring from previous partition to uptil now is palindrome or not
    lets say its not palindrome then move the position of this partition only otherwise move on to the next partition
    everytime start reaches the end its valid partitions, store it in ans
    */

    private static void helper1(String s, int partitionNo, int start, List<String>ans, List<List<String>> lans){
        if(start == s.length()){
            lans.add(new ArrayList<>(ans));
            return;
        }

        //controls the movement of a single partition
        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                ans.add(s.substring(start, i+1));
                helper1(s, partitionNo+1, i+1, ans, lans);
                ans.removeLast();
            }
        }
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> lans = new ArrayList<>();
        helper(s, 0, 0, new int[s.length()], lans);
        return lans;
    }

     /*
    place the first partition anywhere from 0 to n-1, once the first partition is placed, place the second and so on
    second partition will start from the position of first partition + 1 and this can also go uptil n-1 position
    after placing a partition check if the substring from previous partition to uptil now is palindrome or not
    lets say its not palindrome then move the position of this partition only otherwise move on to the next partition
    everytime start reaches the end its valid partitions, store it in ans
    */

    private static void helper(String s, int partitionNo, int start, int[] ans, List<List<String>> lans){
        if(start == s.length()){
            List<String> arr = new ArrayList<>();
            int stInd = 0, i = 0;
            for(; i<ans.length; i++){
                if(ans[i] != 0){
                    arr.add(s.substring(stInd, ans[i]));
                    stInd = ans[i];
                }
            }
            if(stInd != i) arr.add(s.substring(stInd, i));
            lans.add(arr);
            return;
        }

        //controls the movement of a single partition
        for(int i = start; i<s.length(); i++){
            int stInd = partitionNo == 0 ? 0 : ans[partitionNo-1];
            if(isPalindrome(s, stInd, i)){
                ans[partitionNo] = i+1;
                helper(s, partitionNo+1, i+1, ans, lans);
                ans[partitionNo] = 0;
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
