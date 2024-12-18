package SearchingAndSorting.Searching;

//https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/description/
public class SumOfMutatedArrayClosestToTarget {
    public static void main(String[] args) {
        int[] arr = {5,2};
        int target = 100;
        System.out.println(findBestValue(arr, target));
    }

    private static int findBestValue(int[] arr, int target) {
        //TC = O(n) + O(log min(n, t)*n)
        int low = 0, high = Math.min(target, getMax(arr)), ans = -1, prevSum = -1, prevMid = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            int sum = targetSum(arr, target, mid);
            if(sum == target) return mid;

            //I will update my answer if I get a better answer
            if(prevSum == -1 || Math.abs(sum - target) < Math.abs(prevSum - target)){
                ans = mid;
                prevSum = sum;
                prevMid = mid;
            }
            //When there is a tie take the minimum value
            else if(Math.abs(sum - target) == Math.abs(prevSum - target)){
                if(prevMid == -1 || mid < prevMid){
                    ans = mid;
                    prevSum = sum;
                    prevMid = mid;
                }
            }
            if(sum < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    private static int targetSum(int[] arr, int target, int value){
        int sum = 0;
        for(var ele: arr){
            sum += Math.min(ele, value);
        }
        return sum;
    }

    private static int getMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int findBestValueUsingLinearSearch(int[] arr, int target) {
        int diff = -1, ans = -1;
        for(int j = target; j>=0; j--){
            int sum = targetSum(arr, target, j);
            if(diff == -1 || Math.abs(sum - target) <= diff){
                diff = Math.abs(sum-target);
                ans = j;
            }
        }
        return ans;
    }
}
