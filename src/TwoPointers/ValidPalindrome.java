package TwoPointers;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ss :./ss"));
    }
    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l<r){
            char chl = s.charAt(l), chr = s.charAt(r);
            if(!Character.isLetterOrDigit(chl)){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(chr)) {
                r--;
                continue;
            }
            chl = Character.toLowerCase(chl);
            chr = Character.toLowerCase(chr);
            if(chl != chr) return false;
            l++;
            r--;
        }
        return true;
    }
}
