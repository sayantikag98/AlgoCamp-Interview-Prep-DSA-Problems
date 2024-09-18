package ArraysAndHashMap;
import java.util.*;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        List<Integer> lans = findAnagramsUsingArrays("cbaebabacd", "abc");
        System.out.println(lans);
        lans = findAnagramsUsingHashMaps("cbaebabacd", "abc");
        System.out.println(lans);
    }

    private static List<Integer> findAnagramsUsingArrays(String s, String p) {
        //TC = O(ns) + O(np - ns)
        //SC = O(1)
        List<Integer> lans = new ArrayList<>();
        int ns = s.length(), np = p.length();
        if(np<=ns){
            //hms = stores the frequency count of String s
            //hmp = stores the frequency count of String p
            int[] hms = new int[26], hmp = new int[26];

            //keeping the initial window size of the length of String p
            //store the frequency count in the respective array
            for(int i = 0; i<np; i++){
                char chs = s.charAt(i), chp = p.charAt(i);
                hms[chs - 'a']++;
                hmp[chp - 'a']++;
            }

            //matchCount = stores the no of frequency count matches in both the array in the current window
            int matchCount = 0;
            for(int i = 0; i<26; i++){
                if(hms[i] == hmp[i]) matchCount++;
            }
            //if all the indices of both the array matches then its a valid anagram match, so store its starting index
            if(matchCount == 26) lans.add(0);

            //At each iteration just add one element at the right and remove the leftmost element from the window and slide the window to the right
            //decrease the frequency of the leftmost element of the previous window and increase the frequency of the rightmost element of the current window
            for(int i = 0, j = np; j<ns; j++, i++){
                char chi = s.charAt(i), chj = s.charAt(j);
                hms[chi - 'a']--;
                //if decreasing the frequency leads to a match increase the matchCount
                //if prior to decreasing it was a match then decrease the matchCount
                if(hms[chi - 'a'] == hmp[chi - 'a']) matchCount++;
                else if(hms[chi - 'a'] + 1 == hmp[chi - 'a']) matchCount--;
                hms[chj - 'a']++;
                //if increasing the frequency leads to a match increase the matchCount
                //if prior to increasing it was a match then decrease the matchCount
                if(hms[chj - 'a'] == hmp[chj - 'a']) matchCount++;
                else if(hms[chj - 'a'] - 1 == hmp[chj - 'a']) matchCount--;

                //if all the indices of both the array matches then its a valid anagram match, so store its starting index
                if(matchCount == 26) lans.add(i+1);
            }
        }
        return lans;
    }

    private static List<Integer> findAnagramsUsingHashMaps(String s, String p) {
        List<Integer> lans = new ArrayList<>();
        int ns = s.length(), np = p.length();
        if(np<=ns){
            HashMap<Character, Integer> hms = new HashMap<>(), hmp = new HashMap<>();
            for(int i = 0; i<np; i++){
                char chs = s.charAt(i), chp = p.charAt(i);
                hms.put(chs, hms.getOrDefault(chs, 0) + 1);
                hmp.put(chp, hmp.getOrDefault(chp, 0) + 1);
            }
            int matchCount = compareMatch(hms, hmp);
            if(matchCount == hmp.size()) lans.add(0);

            for(int i = 0, j = np; j<ns; j++, i++){
                char chi = s.charAt(i), chj = s.charAt(j);
                int vali = hms.get(chi) - 1;
                if(vali == 0) hms.remove(chi);
                else hms.put(chi, vali);
                if(hmp.containsKey(chi)){
                    if(vali == hmp.get(chi)) matchCount++;
                    else if(vali + 1 == hmp.get(chi)) matchCount--;
                }
                int valj = hms.getOrDefault(chj, 0) + 1;
                hms.put(chj, valj);
                if(hmp.containsKey(chj)){
                    if(valj == hmp.get(chj)) matchCount++;
                    else if(valj - 1 == hmp.get(chj)) matchCount--;
                }
                if(matchCount == hmp.size()) lans.add(i+1);
            }
        }
        return lans;
    }

    private static int compareMatch(HashMap<Character, Integer> hms, HashMap<Character, Integer> hmp){
        int count = 0;
        for(Map.Entry<Character, Integer> e:hms.entrySet()){
            char ch = e.getKey();
            int val = e.getValue();
            if(hmp.containsKey(ch) && hmp.get(ch) == val) count++;
        }
        return count;
    }
}
