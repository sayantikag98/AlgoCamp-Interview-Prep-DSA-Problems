package VariableSlidingWIndow;
import java.util.*;

//https://www.naukri.com/code360/problems/distinct-characters_2221410
//Leetcode Premium: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(kDistinctChars(11, "yxtliihdnnrlhjomdhfektogqbnxs"));
    }
    private static int kDistinctChars(int k, String str) {
        // Write your code here
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxLen = 1;
        for(int i = 0, j = 0; j<str.length(); j++){
            char chJ = str.charAt(j);
            freq.put(chJ, freq.getOrDefault(chJ, 0) + 1);
            while(i<j && freq.size()>k){
                char chI = str.charAt(i);
                int val = freq.get(chI);
                if(val>1) freq.put(chI, val-1);
                else freq.remove(chI);
                i++;
            }
            if(freq.size() <= k){
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}
