package Recursion;
import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/generate-parentheses/description/
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> lans = new ArrayList<>();
        helper(n, 0, 0, new StringBuilder(), lans);
        return lans;
    }

    private static void helper(int n, int o, int c, StringBuilder sb, List<String> lans){
        if(o>n || c>o) return;
        if(c == n){
            lans.add(sb.toString());
            return;
        }
        sb.append('(');
        helper(n, o+1, c, sb, lans);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        helper(n, o, c+1, sb, lans);
        sb.deleteCharAt(sb.length()-1);
    }
}
