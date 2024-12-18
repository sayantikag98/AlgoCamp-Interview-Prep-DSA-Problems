package RecursionAndBacktracking;
import java.util.*;

public class RemoveAllOccurencesOfACharacterInAString {
    public static void main(String[] args) {
        String str = "jdgsdfgjgfhfgdsjfgjg";
        char x = 'g';
        removeAllOccurrence(str, 0, x, "");
        System.out.println(removeAllOccurrence(str, 0, x));


        ArrayList<Character> lans = new ArrayList<>();

        removeAllOccurrence(str, 0, x, lans);


        System.out.println(lans);
    }

    private static void removeAllOccurrence(String str, int i, char x, ArrayList<Character> lans){
        if(i == str.length()){
//            System.out.println(lans);
            return;
        }

        char ch = str.charAt(i);
        if(ch != x){
            lans.add(ch);
            removeAllOccurrence(str, i+1, x, lans);
        }
        else{
            removeAllOccurrence(str, i+1, x, lans);
        }
    }

    private static void removeAllOccurrence(String str, int i, char x,  String ans){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        /*
        String concatenation is a very expensive operation. If string a gets concatenated with string b then TC of that is
        O(n+m) where n & m are the length of the two strings. So in every recursive call string concatenation will take O(n) time and O(n) space
        and there are n recursive calls
        so TC = O(n^2) and SC = O(n^2) so arraylist approach is better in terms of this
         */
        if(str.charAt(i) == x){
            removeAllOccurrence(str, i+1, x, ans);
        }

        else{
            removeAllOccurrence(str, i+1, x, ans+str.charAt(i));
        }
    }

    private static String removeAllOccurrence(String str, int i, char x){
        if(i==str.length()) return "";

        String ans = removeAllOccurrence(str, i+1, x);

        if(str.charAt(i) != x){
            return str.charAt(i) + ans;
        }
        return ans;
    }
}
