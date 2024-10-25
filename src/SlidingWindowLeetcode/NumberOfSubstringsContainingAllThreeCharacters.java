package SlidingWindowLeetcode;
import java.util.HashMap;

//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abbaabbbacbcabcba";
        System.out.println(numberOfSubstrings(s));
        System.out.println(numberOfSubstringsObtimized(s));
    }
    private static int numberOfSubstringsObtimized(String s) {
        //TC = O(n), SC = O(1)
        int[] last = {-1, -1, -1};
        int res = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
            //no of substrings that can be formed having atleast one occurrence of a, b and c ending at index i
            res += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }
        return res;
    }
    private static int numberOfSubstrings(String s) {
        //TC = O(n), SC = O(1)
        int count = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int l = 0, r = 0; r<s.length(); r++){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            while(freq.size() == 3){
                int val = freq.get(s.charAt(l));
                if(val == 1) freq.remove(s.charAt(l));
                else freq.put(s.charAt(l), val-1);
                l++;
                count += (s.length() - r);
            }
        }
        return count;
    }
}
