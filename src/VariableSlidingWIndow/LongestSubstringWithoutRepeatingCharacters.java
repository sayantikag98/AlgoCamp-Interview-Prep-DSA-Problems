package VariableSlidingWIndow;
import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringUsingHashMap("abcabcbb"));
        System.out.println(lengthOfLongestSubstringUsingArray("abcabcbb"));
    }

    private static int lengthOfLongestSubstringUsingArray(String s) {
        int maxLen = 0;
        int[] mapping = new int[256];
        for(int i = 0, j = 0; j<s.length(); j++){
            char ch = s.charAt(j);
            //if the character is already present in the array
            //mapping stores index in one based index
            if(mapping[ch] != 0 && i<=mapping[ch]-1){
                i = mapping[ch];
            }
            //put the index of the current character as one based index in the array
            mapping[ch] = j+1;
            //compute max length for answer
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }

    private static int lengthOfLongestSubstringUsingHashMap(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> mapping = new HashMap<>();
        for(int i = 0, j = 0; j<s.length(); j++){
            char ch = s.charAt(j);
            //if the character is already present in hashmap
            if(mapping.containsKey(ch) && i<=mapping.get(ch)){
                i = mapping.get(ch)+1;
            }
            //put the index of the current character in the hashmap
            mapping.put(ch, j);
            //compute max length for answer
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
