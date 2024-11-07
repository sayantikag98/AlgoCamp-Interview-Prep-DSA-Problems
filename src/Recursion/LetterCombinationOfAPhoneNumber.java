package Recursion;
import java.util.*;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationOfAPhoneNumber {
    static String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        List<String> lans = letterCombinations("234");
        System.out.println(lans);
    }

    private static List<String> letterCombinations(String digits) {
        List<String> lans = new ArrayList<>();
        helper(digits, 0, new StringBuilder(), lans);
        return lans;
    }

    private static void helper(String digits, int i, StringBuilder ans, List<String> lans){
        if(i == digits.length()){
            if(!ans.isEmpty()) lans.add(ans.toString());
            return;
        }

        String str = mapping[digits.charAt(i)-'0'-2];

        for(int j = 0; j<str.length(); j++){
            ans.append(str.charAt(j));
            helper(digits, i+1, ans, lans);
            ans.deleteCharAt(ans.length()-1);
        }

    }
}
