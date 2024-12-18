package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/word-break/
public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = List.of("leetc", "code");
        System.out.println(wordBreak("leetcode", wordDict));
    }
    //similar to leetcode problem palindrome partitioning -
    //there we had to find whether the substring inside each partition is palindrome or not,
    //here we have to find whether the substring inside each partition is present in wordDict or not
    private static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        return helper(s, 0, words, "");
    }


    private static boolean helper(String s, int start, HashSet<String> words, String prevSubStr){
        if(start == s.length()) return true;


        for(int i = start; i<s.length(); i++){
            String substr = s.substring(start, i+1);
            while(i<s.length() && substr.equals(prevSubStr)) {
                i++;
                prevSubStr = substr;
            }
            if(words.contains(substr)){
                boolean isFound = helper(s, i+1, words, substr);
                if(isFound) return true;
            }
        }

        return false;
    }
}
