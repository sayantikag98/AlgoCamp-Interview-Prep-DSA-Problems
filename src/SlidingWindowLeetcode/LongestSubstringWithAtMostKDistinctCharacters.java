
package SlidingWindowLeetcode;
import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(kDistinctChars(2, "cbbcababbddeeegg"));
    }
    public static int kDistinctChars(int k, String str) {
        // Write your code here
        int maxLen = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0, j = 0; j<str.length(); j++){
            freq.put(str.charAt(j), freq.getOrDefault(str.charAt(j), 0) + 1);
            if(freq.size() > k){
                int val = freq.get(str.charAt(i));
                if(val == 1) freq.remove(str.charAt(i));
                else freq.put(str.charAt(i), val - 1);
                i++;
            }
            else maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
