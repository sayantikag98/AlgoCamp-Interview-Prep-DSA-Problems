package ArraysAndHashMap;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutiveUsingHashMap(new int[]{9,5,16,2,4,5,6,15,1}));
        System.out.println(longestConsecutiveUsingHashSet(new int[]{9,5,16,2,4,5,6,15,1}));
    }
    private static int longestConsecutiveUsingHashMap(int[] nums) {
        //TC = O(n), SC = O(n)
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i, !hm.containsKey(i-1));
            if(hm.containsKey(i+1)){
                hm.put(i+1, false);
            }
        }

        int maxLen = 0, maxLenStart = 0;

        for(Entry<Integer, Boolean> entry: hm.entrySet()){
            int len = 0, pStart = 0;
            if(entry.getValue()){
                pStart = entry.getKey();
                while(hm.containsKey(pStart + len)){
                    len++;
                }
                if(maxLen < len){
                    maxLen = len;
                    maxLenStart = pStart;
                }
            }
        }

        return maxLen;
    }

    private static int longestConsecutiveUsingHashSet(int[] nums) {
        //TC = O(n), SC = O(n)
        HashSet<Integer> hs = new HashSet<>();
        for(int i: nums){
            hs.add(i);
        }
        int maxLen = 0;
        for(int i: hs){
            if(!hs.contains(i-1)){
                //i is the start of a consecutive sequence
                int len = 1;
                while(hs.contains(i+len)){
                    len++;
                }
                if(maxLen < len) maxLen = len;
            }
        }
        return maxLen;
    }
}
