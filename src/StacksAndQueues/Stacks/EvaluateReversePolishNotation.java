package StacksAndQueues.Stacks;
import java.util.*;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    private static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(var exp : tokens){
            if(exp.length() > 1 || Character.isDigit(exp.charAt(0))){
                st.push(Integer.parseInt(exp));
            }
            else{
                int operand2 = st.pop(), operand1 = st.pop();
                char operator = exp.charAt(0);
                st.push(evaluate(operand1, operand2, operator));
            }
        }
        return st.pop();
    }

    private static int evaluate(int operand1, int operand2, char operator){
        if(operator == '+') return operand1 + operand2;
        else if(operator == '-') return operand1 - operand2;
        else if(operator == '*') return operand1 * operand2;
        return operand1 / operand2;
    }
}
