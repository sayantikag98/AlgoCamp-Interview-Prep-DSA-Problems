package ArraysAndHashMap;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/permutation-in-string/description/
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusionUsingFixedSlidingWindow("adc", "dcda"));
        System.out.println(checkInclusionUsingOptimizedFixedSlidingWindow("adc", "dcda"));
    }

    private static boolean checkInclusionUsingOptimizedFixedSlidingWindow(String s1, String s2) {
        //TC = O(n1) + O(26) + O(n2-n1) = O(n1)+O(n2-n1)
        //SC = O(26) = O(1)
        int n1 = s1.length(), n2 = s2.length();
        if(n1>n2) return false;
        HashMap<Character, Integer> h1 = new HashMap<>(), h2 = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            char ch = s1.charAt(i), ch1 = s2.charAt(i);
            h1.put(ch, h1.getOrDefault(ch, 0) + 1);
            h2.put(ch1, h2.getOrDefault(ch1, 0) + 1);
        }
        //matchCount = the number of frequency count that match in both the hashmaps within the current window
        int matchCount = getMatchCount(h1, h2);

        if(h1.size() == matchCount) return true;

        for(int i = 0, j = s1.length(); j<s2.length(); i++,j++){
            char chi = s2.charAt(i), chj = s2.charAt(j);
            h2.put(chi, h2.get(chi) - 1);
            //if the key is not present in hashmap then that is not accounted in maxcount
            //if the key is present in hashmap then
            //-decreasing the frequency value if its a match then increase the matchCount
            //-decreasing the frequency value if its a match previously then decrease the matchCount now
            if(h1.containsKey(chi)){
                int val = h2.get(chi);
                if(h1.get(chi) == val) matchCount++;
                else if(h1.get(chi) == val+1) matchCount--;
            }
            if(h2.get(chi) == 0) h2.remove(chi);
            h2.put(chj, h2.getOrDefault(chj, 0) + 1);
            //logic is same as above
            if(h1.containsKey(chj)){
                int val = h2.get(chj);
                if(h1.get(chj) == val) matchCount++;
                else if(h1.get(chj) == val-1) matchCount--;
            }
            if(h1.size() == matchCount) return true;
        }
        return false;
    }

    private static int getMatchCount(HashMap<Character, Integer> h1, HashMap<Character, Integer> h2){
        int count = 0;
        for(Map.Entry<Character, Integer> e:h2.entrySet()){
            int val = e.getValue();
            char ch = e.getKey();
            if(h1.containsKey(ch) && h1.get(ch) == val) count++;
        }
        return count;
    }

    private static boolean checkInclusionUsingFixedSlidingWindow(String s1, String s2) {
        //TC = O(n1) + O(26*(n2-n1+1)), SC = O(26) = O(1)
        int n1 = s1.length(), n2 = s2.length();
        if(n1>n2) return false;
        HashMap<Character, Integer> h1 = new HashMap<>(), h2 = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            char ch = s1.charAt(i), ch1 = s2.charAt(i);
            h1.put(ch, h1.getOrDefault(ch, 0) + 1);
            h2.put(ch1, h2.getOrDefault(ch1, 0) + 1);
        }

        for(int i = 0, j = s1.length(); j<s2.length(); i++,j++){
            if(compare(h1, h2)) return true;
            char chi = s2.charAt(i), chj = s2.charAt(j);
            h2.put(chi, h2.get(chi) - 1);
            if(h2.get(chi) == 0) h2.remove(chi);
            h2.put(chj, h2.getOrDefault(chj, 0) + 1);
        }

        return compare(h1, h2);
    }

    private static boolean compare(HashMap<Character, Integer> h1, HashMap<Character, Integer> h2){
        if(h1.size() != h2.size()) return false;
        for(Map.Entry<Character, Integer> e:h2.entrySet()){
            int val = e.getValue();
            char ch = e.getKey();
            if(!h1.containsKey(ch) || h1.get(ch) != val) return false;
        }
        return true;
    }
}
