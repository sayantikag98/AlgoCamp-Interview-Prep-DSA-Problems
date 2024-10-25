package SlidingWindowLeetcode;
import java.util.Set;
import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate-ii/

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int []{1,2,1,3}, 3));
    }
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> indFound = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(i>k) indFound.remove(nums[i-k-1]);


            //these two lines can be concisely written as ****** if(!indFound.add(nums[i])) return true; *******
            //because the add method returns true if the element is not already added to the hashset and is newly added
            //otherwise it returns false if the element is already present in the hashset
            if(indFound.contains(nums[i])) return true;
            indFound.add(nums[i]);
        }
        return false;
    }
}
