package RecursionAndBacktracking;

public class FrogJumpII {
    public static void main(String[] args) {
        int[] height = {10, 30, 40, 50, 20};
        int k = 3;
        System.out.println(frogJump(height, 0, height.length, k));
    }

    private static int frogJump(int[] height, int i, int n, int k){
        if(i>=n-1) return 0;
        int minCost = Integer.MAX_VALUE;
        for(int j = 1; j<=k; j++){
            int cost = frogJump(height, i+j, n, k);
            if(i+j<n){
                cost += Math.abs(height[i] - height[i+j]);
            }
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
}
