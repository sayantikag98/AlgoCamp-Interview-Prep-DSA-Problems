package StacksAndQueues.Stacks;
import java.util.*;

//https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
public class EvaluationOfPostfixExpression {
    public static void main(String[] args) {
        System.out.println(evaluatePostFix("231*+9-"));
    }
    private static int evaluatePostFix(String S)
    {
        //TC = O(n), SC = O(n)
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<S.length(); i++){
            char ch = S.charAt(i);
            if(Character.isDigit(ch)){
                st.push(ch - '0');
            }
            else{
                if(st.size() >= 2){
                    int op2 = st.pop(), op1 = st.pop(), result = 0;
                    if(ch == '+') result = op1+op2;
                    else if(ch == '-') result = op1-op2;
                    else if(ch == '*') result = op1*op2;
                    else if(op2 != 0) result = op1/op2;
                    st.push(result);
                }
            }
        }
        return st.pop();
    }
}
