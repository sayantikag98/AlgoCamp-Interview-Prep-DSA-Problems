package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/find-unique-binary-string/
public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String[] nums = {"00", "10"};
        System.out.println(findDifferentBinaryString(nums));
    }
    private static String findDifferentBinaryString(String[] nums) {
        HashSet<String> hs = new HashSet<>();
        Collections.addAll(hs, nums);
        StringBuilder sb = new StringBuilder();
        helper(hs, 0, nums[0].length(), sb);
        return sb.toString();
    }

    private static boolean helper(HashSet<String> hs, int i, int n, StringBuilder sb){
        if(i == n){
            return !hs.contains(sb.toString());
        }

        for(int j = 0; j<2; j++){
            sb.append((char)(j+'0')); //for ascii 48
            if(helper(hs, i+1, n, sb)) return true;
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}
