package DailyChallenge;

//https://leetcode.com/problems/string-compression-iii/
public class StringCompressionIII {
    public static void main(String[] args) {
        System.out.println(compressedString("sgfhjgjfgsjdgjfsdfhsgdgggggggggggggg"));
    }
    private static String compressedString(String word) {
        //TC = O(n), SC = O(n)
        StringBuilder sb = new StringBuilder();
        int count = 1, n = word.length();
        for(int i = 1; i<n; i++){
            if(word.charAt(i) == word.charAt(i-1) && count<9){
                count++;
            }
            else{
                sb.append(count).append(word.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count).append(word.charAt(n-1));
        return sb.toString();
    }
}
