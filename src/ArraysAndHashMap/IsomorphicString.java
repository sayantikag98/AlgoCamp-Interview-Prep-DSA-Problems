package ArraysAndHashMap;
import java.util.HashMap;

//https://leetcode.com/problems/isomorphic-strings/description/
public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("ada", "lee"));
        System.out.println(isIsomorphicMostOptimized("ada", "lee"));
    }

    private static boolean isIsomorphicMostOptimized(String s, String t) {
        //TC = O(n), SC = O(1)
        int[] sFound = new int[256], tFound = new int[256];
        for(int i = 0; i<s.length(); i++){
            char chS = s.charAt(i), chT = t.charAt(i);
            if(sFound[chS] != tFound[chT]) return false;
            sFound[chS] = i+1;
            tFound[chT] = i+1;
        }
        return true;
    }

    private static boolean isIsomorphic(String s, String t) {
        //TC = O(n), SC = O(n)
        HashMap<Character, Character> mapping = new HashMap<>();
        // HashSet<Character> charUsed = new HashSet<>();
        boolean[] charUsed = new boolean[255];

        for(int i = 0; i<s.length(); i++){
            char chS = s.charAt(i), chT = t.charAt(i);
            if(mapping.containsKey(chS)){
                if(chT != mapping.get(chS)) return false;
            }
            else{
                // if(charUsed.contains(chT)) return false;
                if(charUsed[chT]) return false;
                mapping.put(chS, chT);
                // charUsed.add(chT);
                charUsed[chT] = true;
            }
        }

        return true;
    }
}
