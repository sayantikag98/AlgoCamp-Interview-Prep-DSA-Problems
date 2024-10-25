package SlidingWindowLeetcode;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{8,1,16,5,6,2,12,10}, 4));
    }
    private static int maxScore(int[] cardPoints, int k) {
        //TC = O(2*k) ~ O(n), SC = O(1)
        int i = 0, lsum = 0, rsum = 0, n = cardPoints.length;
        while(i<k){
            lsum += cardPoints[i];
            i++;
        }

        if(n == k) return lsum;
        int maxSum = lsum;
        i--;

        while(i>=0){
            lsum -= cardPoints[i];
            rsum += cardPoints[i+n-k];
            maxSum = Math.max(maxSum, lsum+rsum);
            i--;
        }

        return maxSum;
    }
}
