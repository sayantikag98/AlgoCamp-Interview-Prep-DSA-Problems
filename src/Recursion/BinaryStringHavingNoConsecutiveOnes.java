package Recursion;
import java.util.*;

public class BinaryStringHavingNoConsecutiveOnes {
    public static void main(String[] args) {
        List<String> lans = new ArrayList<>();
        findAllBinaryStrings(3, "", lans);
        System.out.println(lans);
        lans.clear();
        findAllBinaryStrings(3, new StringBuilder(), lans);
        System.out.println(lans);
    }

    private static void findAllBinaryStrings(int n, String ans, List<String> lans){
        if(n == 0){
            lans.add(ans);
            return;
        }
        findAllBinaryStrings(n-1, ans+'0', lans);
        if(ans.isEmpty() || ans.charAt(ans.length()-1) == '0'){
            findAllBinaryStrings(n-1, ans+'1', lans);
        }
    }


    private static void findAllBinaryStrings(int n, StringBuilder sb, List<String> lans){
        if(n==0){
            lans.add(sb.toString());
            return;
        }
        sb.append('0');
        findAllBinaryStrings(n-1, sb, lans);
        sb.deleteCharAt(sb.length()-1);
        if(sb.isEmpty() || sb.charAt(sb.length()-1) == '0'){
            sb.append('1');
            findAllBinaryStrings(n-1, sb, lans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
