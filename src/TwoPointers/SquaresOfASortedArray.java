package TwoPointers;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] ans = sortedSquares(new int[]{-4, -1, 2, 3});
        for(int ele: ans){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    private static int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length-1, k = r;
        int[] ans = new int[nums.length];
        while(l<=r){
            if(Math.abs(nums[l])>=Math.abs(nums[r])){
                ans[k] = nums[l]*nums[l];
                k--;
                l++;
            }
            else{
                ans[k] = nums[r]*nums[r];
                k--;
                r--;
            }
        }
        return ans;
    }
}
