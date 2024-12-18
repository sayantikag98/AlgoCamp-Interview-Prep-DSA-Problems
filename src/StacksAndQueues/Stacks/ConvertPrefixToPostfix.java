package StacksAndQueues.Stacks;
import java.util.*;

public class ConvertPrefixToPostfix {
    public static void main(String[] args) {
        System.out.println(preToPost("/A+BC"));
    }
    private static String preToPost(String s) {
        // Write Your Code Here
        Stack<StringBuilder> st = new Stack<>();
        for(int i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch != '+' && ch != '-' && ch != '*' && ch != '/'){
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                st.push(sb);
            }
            else{
                StringBuilder op1 = st.pop(), op2 = st.pop();
                op1.append(op2).append(ch);
                st.push(op1);
            }
        }
        return st.peek().toString();
    }
}
