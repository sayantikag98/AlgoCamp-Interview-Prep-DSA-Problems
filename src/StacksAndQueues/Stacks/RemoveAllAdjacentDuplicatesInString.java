package StacksAndQueues.Stacks;
import java.util.*;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    private static String removeDuplicates(String s) {
        //TC = O(n), SC = O(n)
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            boolean isDuplicate = false;
            while(!st.empty() && s.charAt(i) == st.peek()){
                isDuplicate = true;
                st.pop();
            }
            if(!isDuplicate){
                st.push(s.charAt(i));
            }
        }
        char[] chArr = new char[st.size()];
        int i = chArr.length-1;
        while(!st.empty()){
            chArr[i--] = st.pop();
        }
        return String.valueOf(chArr);
    }
}
