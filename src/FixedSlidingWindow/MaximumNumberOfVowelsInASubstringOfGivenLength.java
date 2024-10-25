package FixedSlidingWindow;
//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        System.out.println(maxVowels("aeiou", 2));
    }
    private static int maxVowels(String s, int k) {
        int maxCount = 0, count = 0, i = 0, j = 0;

        while(j<s.length()){
            if(j-i == k){
                maxCount = Math.max(maxCount, count);
                if(isVowel(s.charAt(i))) count--;
                i++;
            }
            if(isVowel(s.charAt(j))) count++;
            j++;

        }
        return Math.max(maxCount, count);
    }

    private static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
