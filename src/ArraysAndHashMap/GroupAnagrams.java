package ArraysAndHashMap;
import java.util.*;

//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> lans = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(lans);
        lans = groupAnagramsOptimized(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(lans);
    }

    private static List<List<String>> groupAnagramsOptimized(String[] strs) {
        //TC = O(n * m+mlogm) + O(n)
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> lans = new ArrayList<>();
        for(String s:strs){
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
            String str = String.valueOf(chArr);
            if(hm.containsKey(str)){
                hm.get(str).add(s);
            }
            else{
                List<String> ans = new ArrayList<>();
                ans.add(s);
                lans.add(ans);
                hm.put(str, ans);
            }
        }

        return lans;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        //TC = O(n * (m+mlogm)) + O(n)
        //SC = O(n*m) + O(n)
        String[] sortedStr = new String[strs.length];
        for(int i = 0; i<strs.length; i++){
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            sortedStr[i] = String.valueOf(chArr);
        }

        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> lans = new ArrayList<>();
        for(int i = 0; i<strs.length; i++){
            if(hm.containsKey(sortedStr[i])){
                hm.get(sortedStr[i]).add(strs[i]);
            }
            else{
                List<String> ans = new ArrayList<>();
                ans.add(strs[i]);
                lans.add(ans);
                hm.put(sortedStr[i], ans);
            }
        }

        return lans;
    }
}
