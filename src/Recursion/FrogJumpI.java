package Recursion;

public class FrogJumpI {
    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJump(height, 0, height.length));
        System.out.println(frogJumpInOpposite(height, height.length));
    }
    private static int frogJump(int[] height, int i, int n){
        if(i>=n-1) return 0;
        int costOneStep = frogJump(height, i+1, n);
        int costTwoStep = frogJump(height, i+2, n);
        int ans = costOneStep + Math.abs(height[i] - height[i+1]);
        if(i<n-2){
            ans = Math.min(ans, costTwoStep + Math.abs(height[i] - height[i+2]));
        }
        return ans;
    }

    private static int frogJumpInOpposite(int[] height, int n){
        if(n<=1) return 0;
        int costOneStep = frogJumpInOpposite(height, n-1);
        int costTwoStep = frogJumpInOpposite(height, n-2);
        int ans = costOneStep + Math.abs(height[n-1] - height[n-2]);
        if(n>=3){
            ans = Math.min(ans, costTwoStep + Math.abs(height[n-1] - height[n-3]));
        }
        return ans;
    }
}
