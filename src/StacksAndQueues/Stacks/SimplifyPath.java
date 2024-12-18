package StacksAndQueues.Stacks;
import java.util.*;

//https://leetcode.com/problems/simplify-path/
public class SimplifyPath {
    public static void main(String[] args) {
        String str = "/....///../home/../../abc/.../.././/";
        System.out.println(simplifyPathUsingDeque(str));
        System.out.println(simplifyPathUsingStack(str));
    }
    private static String simplifyPathUsingDeque(String path) {
        //TC = O(n), SC = O(n)
        String[] str = path.trim().split("/");
        Deque<String> st = new LinkedList<>();
        for(var s: str){
            if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pollLast();
                }
            }
            else if(!s.isEmpty() && !s.equals(".")){
                st.offer(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while(!st.isEmpty()){
            sb.append(st.poll());
            sb.append("/");
        }

        if(sb.length()>1) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private static String simplifyPathUsingStack(String path) {
        //TC = O(n), SC = O(n)
        String[] str = path.trim().split("/");
        Stack<String> st = new Stack<>();
        for(var s: str){
            if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else if(!s.isEmpty() && !s.equals(".")){
                st.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(var s: st){
            sb.append("/");
            sb.append(s);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}
