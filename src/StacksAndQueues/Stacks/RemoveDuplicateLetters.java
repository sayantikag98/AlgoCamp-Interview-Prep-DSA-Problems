package StacksAndQueues.Stacks;

//NOT COMPLETED - PLEASE CHECK LATER
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String str = "cbacdcbc";
        System.out.println(removeDuplicateLetters(str));
    }
    private static String removeDuplicateLetters(String s) {
        boolean[] isPresentList = new boolean[26];
        for(int i = 0; i<s.length(); i++){
            isPresentList[s.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<26; i++){
            if(isPresentList[i]){
                sb.append(i + 'a');
            }
        }
        return sb.toString();
    }
}
