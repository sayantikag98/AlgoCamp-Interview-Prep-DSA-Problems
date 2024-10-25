package ArraysAndHashMap;

//https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring1("bcdghabdcghijklnmop"));
        System.out.println(longestContinuousSubstring2("bcdghabdcghijklnmop"));
    }

    private static int longestContinuousSubstring2(String s) {
        int i = 0, ans = 0;
        for(int j = 1; j<s.length(); j++){
            if(s.charAt(j) - s.charAt(j-1) != 1){
                ans = Math.max(ans, j-i);
                i = j;
            }
        }
        return Math.max(ans, s.length()-i);
    }
    private static int longestContinuousSubstring1(String s) {
        //TC = O(n), SC = O(1)
        int i = 0, j = 0, ans = 0;
        char k = s.charAt(j);
        while(j<s.length()){
            if(s.charAt(j) == k){
                k++;
                j++;
            }
            else{
                ans = Math.max(ans, j-i);
                i = j;
                k = s.charAt(j);
            }
        }
        return Math.max(ans, j-i);
    }
}
