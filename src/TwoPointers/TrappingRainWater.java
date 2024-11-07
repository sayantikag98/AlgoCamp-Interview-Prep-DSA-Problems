package TwoPointers;

//https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {2,4,6,3,1,5,6,1};
        System.out.println(trapUsingExtraSpace(height));
        System.out.println(trapWithNoSpace(height));
        System.out.println(trapMostOptimized(height));
    }
    private static int trapMostOptimized(int[] height) {
        //TC = O(n), SC = O(1)
        //NO STACK REQUIRED
        //COMPUTE MAX TILL NOW FROM LEFT AND RIGHT
        //NEXT GREATER ELEMENT FROM LEFT AND RIGHT IS NOT NEEDED
        int ans = 0, lmax = 0, rmax = lmax, l = 0, r = height.length-1;

        //place l and r pointer at extreme ends and move l or r based on whether lmax or rmax is minimum
        //because water could only be stored on the minimum of left and right wall surrounding - height
        while(l<=r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if(lmax<=rmax){
                ans += (lmax - height[l]);
                l++;
            }
            else{
                ans += (rmax - height[r]);
                r--;
            }
        }
        return ans;
    }
    private static int trapWithNoSpace(int[] height) {
        //TC = O(n), SC = O(1)
        //NO STACK REQUIRED
        //COMPUTE MAX TILL NOW FROM LEFT AND RIGHT
        //NEXT GREATER ELEMENT FROM LEFT AND RIGHT IS NOT NEEDED
        int n = height.length, ans = 0, maxInd = 0, max = 0, i;

        for(i = 0; i<n; i++){
            if(height[maxInd] < height[i]){
                maxInd = i;
            }
        }

        for(i = 0; i<maxInd; i++){
            max = Math.max(max, height[i]);
            ans += (max - height[i]);
        }

        max = Integer.MIN_VALUE;

        for(i = n-1; i>maxInd; i--){
            max = Math.max(max, height[i]);
            ans += (max - height[i]);
        }

        return ans;
    }
    private static int trapUsingExtraSpace(int[] height) {
        //TC = O(n), SC = O(n)
        //NO STACK REQUIRED
        //COMPUTE MAX TILL NOW FROM LEFT AND RIGHT
        //NEXT GREATER ELEMENT FROM LEFT AND RIGHT IS NOT NEEDED
        int n = height.length, ans = 0, max = Integer.MIN_VALUE;
        int[] nger = new int[n];

        for(int i = n-1; i>=0; i--){
            max = Math.max(height[i], max);
            nger[i] = max;
        }

        max = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            max = Math.max(height[i], max);
            ans+=(Math.min(nger[i], max)-height[i]);
        }

        return ans;
    }
}
