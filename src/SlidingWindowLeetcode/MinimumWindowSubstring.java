package SlidingWindowLeetcode;
import java.util.HashMap;

//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "bba", t = "ab";
        System.out.println(minWindowUsingMySoln(s, t));
        System.out.println(minWindowUsingStriverCountApproach(s, t));
    }

    private static String minWindowUsingStriverCountApproach(String s, String t) {
        //TC = O(n+m), SC = O(1)
        //count for valid window, start is the start index of the substring formed by current window (inclusive),
        //end is the end index + 1 of the substring formed by the current window (exclusive)
        int count = 0, start = 0, end = 0, minLength = Integer.MAX_VALUE;
        //why 58?
        //constraint given in the question all lowercase (97 to 122 ascii values) and uppercase (65 to 90 ascii values) english alphabets
        // so 122 - 64 = 58
        int[] freq = new int[58];

        //storing all the characters frequency of string t
        for(int i = 0; i<t.length(); i++){
            freq[t.charAt(i)-65]++;
        }

        //valid window => count = size of string t

        int i = 0, j = 0;

        while(j<s.length()){
            //expanding the current window by moving j to the right till j is outside bound of string s or window is valid

            while(j<s.length() && count<t.length()){
                char chJ = s.charAt(j);
                //if the current frequency count of the character (chJ) is > 0 then increment count and then decrease the frequency
                if(freq[chJ-65]-->0) count++; //******* IN INTERVIEW BREAK THIS STATEMENT IN TWO PARTS FOR BETTER READABILITY
                j++;
            }

            //whenever the window is valid start shrinking the window by i to the right till the window is invalid
            while(count == t.length()){
                char chI = s.charAt(i);
                //if its minimum till now update length, start index and end index
                if(j-i<minLength){
                    minLength = j-i;
                    start = i;
                    end = j;
                }

                //if the frequency count of the character (chI) is >= 0 then decrease count and then increment the frequency
                if(freq[chI-65]++>=0) count--;
                i++;
            }
        }

        //compute substring at last
        return s.substring(start, end);
    }

    private static String minWindowUsingMySoln(String s, String t) {
        //TC = O(n) + O(m), SC = O(no of distinct characters in string t)
        HashMap<Character, Integer> freqT = new HashMap<>(), freqS = new HashMap<>();
        int startInd = 0, endInd = 0;
        //store frequency of all characters of string t
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        }

        //first valid window search
        //valid window => if every character in t (including duplicates) is included in the window
        int i = 0, j = 0;
        while(j<s.length() && !isEqual(freqT, freqS)){
            char ch = s.charAt(j);
            //store only the characters present in string t in freqS hashmap
            if(freqT.containsKey(ch)){
                freqS.put(ch, freqS.getOrDefault(ch, 0) + 1);
            }
            j++;
        }



        //once the first valid window is found shrink the window till its invalid because we need the minimum window
        //and subsequently update the start and end index for substring computation in the valid window
        while(isEqual(freqT, freqS)){
            startInd = i;
            endInd = j;
            char chI = s.charAt(i);
            if(freqS.containsKey(chI)){
                int val = freqS.get(chI);
                if(val == 1) freqS.remove(chI);
                else freqS.put(chI, val-1);
            }
            i++;
        }

        while(j<s.length()){
            //slide the window towards right by adding jth character to the right and deleting ith character to the left
            char chJ = s.charAt(j), chI = s.charAt(i);
            //store only the characters present in string t in freqS hashmap
            if(freqT.containsKey(chJ)){
                freqS.put(chJ, freqS.getOrDefault(chJ, 0) + 1);
            }
            j++;
            if(freqS.containsKey(chI)){
                int val = freqS.get(chI);
                if(val == 1) freqS.remove(chI);
                else freqS.put(chI, val-1);
            }
            i++;


            //whenever we find a valid window shrink the window till its invalid and subsequently update
            //the start and end index for substring computation in the valid window
            while(i<s.length() && isEqual(freqT, freqS)){
                startInd = i;
                endInd = j;
                chI = s.charAt(i);
                if(freqS.containsKey(chI)){
                    int val = freqS.get(chI);
                    if(val == 1) freqS.remove(chI);
                    else freqS.put(chI, val-1);
                }
                i++;
            }

        }

        //once j reaches the end delete the ith character and subsequently increment i till i also reaches the end
        //when the window is valid update start and end index for substring computation in the final answer
        while(i<s.length()){
            char chI = s.charAt(i);
            if(freqS.containsKey(chI)){
                int val = freqS.get(chI);
                if(val == 1) freqS.remove(chI);
                else freqS.put(chI, val-1);
            }
            i++;
            if(isEqual(freqT, freqS)) {
                startInd = i;
                endInd = j;
            }
        }

        //compute substring only for the final minimum window
        return s.substring(startInd, endInd);
    }


    //to check whether the window is valid or not
    //checking freqT.equals(freqS) is not sufficient => MADE MISTAKE HERE
    //valid => size of both hashmap same and freq of every character in s has to be >= the frequency of the corresponding character in t for current window
    private static boolean isEqual(HashMap<Character, Integer> freqT, HashMap<Character, Integer> freqS){
        // if(freqT.equals(freqS)) return true;
        if(freqT.size() != freqS.size()) return false;
        for(char key: freqT.keySet()){
            if(freqS.get(key)<freqT.get(key)) return false;
        }
        return true;
    }
}
