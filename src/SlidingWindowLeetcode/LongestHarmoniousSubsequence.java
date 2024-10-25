package SlidingWindowLeetcode;
import java.util.HashMap;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,1,2,1}));
    }
    private static int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        for(int ele: nums){
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
            if(freq.containsKey(ele-1)){
                ans = Math.max(ans, freq.get(ele) + freq.get(ele-1));
            }
            if(freq.containsKey(ele+1)){
                ans = Math.max(ans, freq.get(ele) + freq.get(ele+1));
            }
        }

        return ans;
    }
}
