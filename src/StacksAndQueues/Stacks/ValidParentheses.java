package StacksAndQueues.Stacks;
import java.util.*;

import BinaryTree.Pair;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{}{[}]";
        System.out.println(isValid(s));
        System.out.println(isValidRecursive(s, 0, new Stack<>()));
    }

    private static boolean isValid(String s) {
        //TC = O(n), SC = O(n)
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.empty()) return false;
                if(ch == ')'){
                    if(st.peek() == '(') st.pop();
                    else return false;
                }
                else if(ch == '}'){
                    if(st.peek() == '{') st.pop();
                    else return false;
                }
                else{
                    if(st.peek() == '[') st.pop();
                    else return false;
                }
            }
        }
        return st.empty();
    }

    private static boolean isValidRecursive(String s, int idx, Stack<Character> st){
        //TC = O(n), SC = O(n)
        if(idx == s.length()) return st.empty();
        char ch = s.charAt(idx);
        if(ch == '(' || ch == '{' || ch == '['){
            st.push(ch);
        }
        else{
            if(st.empty()) return false;
            if(ch == ')'){
                if(st.peek() == '(') st.pop();
                else return false;
            }
            else if(ch == '}'){
                if(st.peek() == '{') st.pop();
                else return false;
            }
            else{
                if(st.peek() == '[') st.pop();
                else return false;
            }
        }
        return isValidRecursive(s, idx+1, st);
    }


    ///// THIS WILL NOT WORK FOR CASE LIKE s = {}{[}]
//    private static boolean isValid1(String s){
//        int count1 = 0, count2 = 0, count3 = 0;
//        for(int i = 0; i<s.length(); i++){
//            char ch = s.charAt(i);
//            if(ch == '(') count1++;
//            else if(ch == '{') count2++;
//            else if(ch == '[') count3++;
//            else if(ch == ')'){
//                if(count1 == 0) return false;
//                count1--;
//            }
//            else if(ch == '}'){
//                if(count2 == 0) return false;
//                count2--;
//            }
//            else{
//                if(count3 == 0) return false;
//                count3--;
//            }
//        }
//        return count1 == 0 && count2 == 0 && count3 == 0;
//    }
}
