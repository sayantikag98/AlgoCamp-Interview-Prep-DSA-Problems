package StacksAndQueues.Stacks;
import java.util.*;

public class EvaluationOfPrefixExpression {
    public static void main(String[] args) {
        System.out.println(evaluatePrefixExpression("-9+*531"));
    }

    private static int evaluatePrefixExpression(String str){
        Stack<Integer> st = new Stack<>();
        for(int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                st.push(ch - '0');
            }
            else{
                if(st.size()>=2){
                    int op2 = st.pop(), op1 = st.pop(), result = 0;
                    if(ch == '+'){
                        result = op1+op2;
                    }
                    else if (ch == '-') {
                        result = op1-op2;
                    }
                    else if(ch == '*'){
                        result = op1*op2;
                    }
                    else if(ch == '/' && op2 != 0){
                        result = op1/op2;
                    }
                    st.push(result);
                }
            }
        }
        return st.pop();
    }
}
