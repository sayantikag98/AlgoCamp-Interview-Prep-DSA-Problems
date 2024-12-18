package StacksAndQueues.Stacks;
import java.util.*;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String s = "))((";
        System.out.println(minRemoveToMakeValid1(s));
        System.out.println(minRemoveToMakeValid(s));
    }

    private static String minRemoveToMakeValid1(String s) {
        //TC = O(n), SC = O(n)
        HashSet<Integer> hs = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                //for now i am not sure whether the opening brace is balanced or not
                st.push(i);
                hs.add(i);
            }
            else if(ch == ')'){
                //if the stack is not empty we found a balance pair
                if(!st.empty()){
                    hs.remove(st.pop());
                }
                //if the stack is empty then it is unbalanced and need to be removed so mark it
                else{
                    hs.add(i);
                }
            }
        }

        //if the stack is non-empty at the end then remove all those opening braces
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(!hs.contains(i)){
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    private static String minRemoveToMakeValid(String s) {
        //TC = O(n), SC = O(n)
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                //for now i am not sure whether the opening brace is balanced or not
                st.push(i);
            }
            else if(ch == ')'){
                //if the stack is not empty we found a balance pair
                if(!st.empty()){
                    st.pop();
                }
                //if the stack is empty then it is unbalanced and need to be removed so mark it
                else{
                    sb.setCharAt(i, '#');
                }
            }
        }
        while(!st.empty()){
            sb.setCharAt(st.peek(), '#');
            st.pop();
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<sb.length(); i++){
            if(sb.charAt(i) != '#'){
                ans.append(sb.charAt(i));
            }

        }
        return ans.toString();
    }
}
