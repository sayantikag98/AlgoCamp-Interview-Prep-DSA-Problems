package TwoPointers;

//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    private static int maxArea(int[] height) {
        int maxWater = 0, l = 0, r = height.length-1;
        while(l<r){
            if(height[l]<=height[r]){
                maxWater = Math.max(maxWater, height[l] * (r-l));
                l++;
            }
            else{
                maxWater = Math.max(maxWater, height[r] * (r-l));
                r--;
            }
        }
        return maxWater;
    }
}
