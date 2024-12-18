package StacksAndQueues.Stacks;
import java.util.*;

public class EvaluationOfInfixExpression {
    public static void main(String[] args) {
        String s = "(3*(5+2)*(10-7))";
        System.out.println(infixEvaluation(s));
    }
    private static int infixEvaluation(String s){
        //TC = O(n), SC = O(n)
        Stack<Integer> stDigit = new Stack<>();
        Stack<Character> stOperator = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int j = i, num = 0;
                while(j<s.length() && Character.isDigit(s.charAt(j))){
                    num = num*10+(s.charAt(j) - '0');
                    j++;
                }
                stDigit.push(num);
                i = j-1;
            }
            else{
                if(ch == '(' || ch == '*' || ch == '/' || ch == '%'){
                    stOperator.push(ch);
                }
                else if(ch == '-' || ch == '+'){
                    while(!stOperator.empty() && stOperator.peek() != '('){
                        evaluate(stDigit, stOperator);
                    }
                    stOperator.push(ch);
                }
                else{
                    while(stOperator.peek() != '('){
                        evaluate(stDigit, stOperator);
                    }
                    stOperator.pop();
                }
            }
        }
        while(!stOperator.empty()){
            evaluate(stDigit, stOperator);
        }
        return stDigit.pop();
    }



    private static void evaluate(Stack<Integer> stDigit, Stack<Character> stOperator) {
        int operand2 = stDigit.pop(), operand1 = stDigit.pop();
        char operator = stOperator.pop();
        if(operator == '+') stDigit.push(operand1 + operand2);
        else if(operator == '-') stDigit.push(operand1 - operand2);
        else if(operator == '*') stDigit.push(operand1 * operand2);
        else if(operator == '/' && operand2 != 0) stDigit.push(operand1 / operand2);
        else if(operator == '%' && operand2 != 0) stDigit.push(operand1 % operand2);
    }
}
