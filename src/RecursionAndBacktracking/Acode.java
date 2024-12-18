package RecursionAndBacktracking;
import java.util.*;

public class Acode {
    public static void main(String[] args) {
        List<String> lans = new ArrayList<>();
        printCombinations("123", 0, new StringBuilder(), lans);
        System.out.println(lans);
    }

    private static void printCombinations(String str, int i, StringBuilder sb, List<String> lans){
        if(i == str.length()){
            lans.add(sb.toString());
            return;
        }

        //single digit
        int digit = str.charAt(i) - '0';
        sb.append((char)(digit + 64));
        printCombinations(str, i+1, sb, lans);
        sb.deleteCharAt(sb.length()-1);

        //double digit
        if(i<str.length()-1){
//            int twoDigit = Integer.parseInt(""+str.charAt(i)+str.charAt(i+1));
            int secondDigit = str.charAt(i+1) - '0',
                    twoDigit = digit * 10 + secondDigit;
            if(twoDigit<27){
                sb.append((char)(twoDigit + 64));
                printCombinations(str, i+2, sb, lans);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
