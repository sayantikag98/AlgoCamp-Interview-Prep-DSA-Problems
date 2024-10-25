package ArraysAndHashMap;
import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    private static boolean containsDuplicate(int[] nums) {
        //TC = O(n), SC = O(n)
        HashSet<Integer> hs = new HashSet<>();
        for(int ele: nums){
            if(hs.contains(ele)) return true;
            hs.add(ele);
        }
        return false;
    }
}
