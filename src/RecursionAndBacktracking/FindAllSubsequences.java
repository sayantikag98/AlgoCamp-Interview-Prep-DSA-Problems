package RecursionAndBacktracking;

public class FindAllSubsequences {
    public static void main(String[] args) {
        findSubsequences("abc", "", 0);
    }

    private static void findSubsequences(String str, String ans, int i){
        if(i == str.length()){
            if(ans.isEmpty()){
                System.out.println("Empty");
            }
            else System.out.println(ans);
            return;
        }

        findSubsequences(str, ans+str.charAt(i), i+1);
        findSubsequences(str, ans, i+1);
    }
}
