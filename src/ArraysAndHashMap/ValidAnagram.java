package ArraysAndHashMap;
import java.util.HashMap;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("ca$t", "a*ct"));
    }

    private static boolean isAnagram(String s, String t) {
        //TC = O(n), SC = O(n)
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char chS = s.charAt(i), chT = t.charAt(i);
            freq.put(chS, freq.getOrDefault(chS, 0) + 1);
            freq.put(chT, freq.getOrDefault(chT, 0) - 1);
            if(freq.get(chS) == 0) freq.remove(chS);
            if(chS != chT && freq.get(chT) == 0) freq.remove(chT);
        }

        return freq.isEmpty();
    }
}
