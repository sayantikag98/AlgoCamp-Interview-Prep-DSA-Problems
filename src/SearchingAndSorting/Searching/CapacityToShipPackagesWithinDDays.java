package SearchingAndSorting.Searching;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        System.out.println(shipWithinDays(weights, days));
    }
    private static int shipWithinDays(int[] weights, int days) {
        //very similar to chocolate distribution problem
        //TC = O(n*log(max of weights[i] * n where 0<=i<n)), SC = O(1)

        //to get the upper consider days = 1, then max sum out of weights array should be the upper bound of max weight capacity
        //max sum of weights array = max of weights[i] * n
        int low = 1, high = getMax(weights) * weights.length, ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isValid(weights, days, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    private static boolean isValid(int[] weights, int totalDays, int maxWeight){
        int sumWeight = 0, days = 1;
        for(var weight: weights){
            if(weight > maxWeight) return false;
            sumWeight += weight;
            if(sumWeight > maxWeight){
                days++;
                sumWeight = weight;
            }
            if(days > totalDays) return false;
        }
        return true;
    }

    private static int getMax(int[] weights){
        int max = weights[0];
        for(int i = 1; i<weights.length; i++){
            max = Math.max(max, weights[i]);
        }
        return max;
    }

}
