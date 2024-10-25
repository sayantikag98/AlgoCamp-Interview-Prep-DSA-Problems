package ArraysAndHashMap;

//https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaBruteForce(height));
        System.out.println(maxAreaMostOptimizedUsingTwoPointers(height));
    }

    private static int maxAreaMostOptimizedUsingTwoPointers(int[] height) {
        //TC = O(n), SC = O(1)
        int left = 0, right = height.length-1, maxWaterStored = 0;
        while(left<right){
            int waterStored = (right - left) * Math.min(height[left], height[right]);
            maxWaterStored = Math.max(maxWaterStored, waterStored);
            if(height[left] <= height[right]) left++;
            else right--;
        }
        return maxWaterStored;
    }
    
    private static int maxAreaBruteForce(int[] height) {
        //TC = O(n^2), SC = O(1)
        int maxWater = 0, n = height.length;
        for(int i = 0; i<n; i++){
            int l = 0;
            while(l<i){
                if(height[l]<height[i]) l++;
                else break;
            }
            int r = n-1;
            while(r>i){
                if(height[r]<height[i]) r--;
                else break;
            }
            maxWater = Math.max(maxWater, Math.max(i-l, r-i) * height[i]);
        }
        return maxWater;
    }
}
