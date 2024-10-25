package SlidingWindowLeetcode;
import java.util.HashMap;

//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("BCCABCDDEDFDBCAFD", 4));
    }
    private static int characterReplacement(String s, int k) {
        //TC = O(n)
        int ans = 0, maxFreqCount = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0, j = 0; j<s.length(); j++){
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
            //to get the maximum frequency of all characters seen till now
            maxFreqCount = Math.max(maxFreqCount, freq.get(s.charAt(j)));

            //if the window size is less than or equal the longest window obtained so far then no need to shrink
            //valid window = length of the current window (j-i+1) - max frequency obtained till now <= k (atmost k)
            // if the window size is greater than max window size obtained so far and the window becomes invalid then
            // only shrink the current window by only one and not further because that will not contribute to answer anyway

            if(j-i+1 > ans && j-i+1-maxFreqCount > k){
                //shrink the window by one character

                /*
                The syntax freq.compute(s.charAt(i++), (key, val) -> val-1); is commonly used in Java to update the value associated with a key in a Map. Let's break it down:
                Components:

                freq.compute(key, remappingFunction):
                    freq is a Map, and compute is a method that updates the value associated with a given key.
                    key: The key to compute (in this case, s.charAt(i++)).
                    remappingFunction: A function that takes two parameters, the key and the current value (val), and returns a new value for that key.

                s.charAt(i++):
                    This extracts the character at index i from the string s. The i++ means that after retrieving the character at position i, the index i is incremented.

                (key, val) -> val - 1:
                    This is a lambda expression (an anonymous function) that takes two parameters:
                        key: The key in the Map, which is s.charAt(i++).
                        val: The current value associated with this key.
                The lambda returns val - 1, meaning it decrements the current value of this key in the Map.
                The compute method is useful because it ensures atomic updates on the map, meaning that it handles cases where the key might not be present and avoids needing to check the map separately for null values.
                 */
                freq.compute(s.charAt(i++), (key, val) -> val - 1);

                //no need to update the max freq because
                /*
                let's say the current length of window is 5 and maxFreqCount is 3 and 5 is already my answer
                so when the length increases to 6 max frequency should also increase in order to be an answer
                if the max freq is same or decrease then it can never be my answer
                */

                //*********************** NOT NEEDED AS MENTIONED ABOVE *******************************

//                //if the max frequency is there for the character which has been removed from window then only do this
//                if(maxFreqCount == val){
//                    maxFreqCount--;
//                    //if there are multiple characters having that max frequency
//                    //then max frequency does not change
//                    //otherwise reduce it by one
//                    for(int ele: freq.values()){
//                        if(val == ele){
//                            maxFreqCount++;
//                            break;
//                        }
//                    }
//                }
                //*****************************************************************************
            }
            //if the current window is greater than the max window obtained so far, and it is valid then store it as answer
            if(j-i+1 > ans && j-i+1-maxFreqCount <= k){
                ans = j-i+1;
            }
        }
        return ans;
    }
}
