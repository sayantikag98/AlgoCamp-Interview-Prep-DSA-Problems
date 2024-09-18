package ArraysAndHashMap;

import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abbaccddcdcdcdedc"));
    }

    private static int lengthOfLongestSubstring(String s) {
        //TC = O(n), SC = O(m), where n is the length
        // of the given input string and m is the total
        // no of distinct characters in the given string
        int n = s.length();
        if(n<2) return n;
        int i = 0, j, maxLen = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(j = 0; j<n; j++){
            char ch = s.charAt(j);
            if(hm.containsKey(ch) && hm.get(ch) >= i){
                maxLen = Math.max(maxLen, j - i);
                i = hm.get(ch) + 1;
            }
            hm.put(ch, j);
        }
        return Math.max(maxLen, j - i);
    }
}
