package DailyChallenge;
//https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/?envType=daily-question&envId=2024-11-15

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        int[] nums = {1,2,3,10,4,2,3,5};
        System.out.println(findLengthOfShortestSubarray1(nums));
        System.out.println(findLengthOfShortestSubarray2(nums));
    }

    //TC = O(n), SC = O(1)
    private static int findLengthOfShortestSubarray2(int[] arr) {
        int n = arr.length, right = n-1;
        while(right>0 && arr[right-1]<=arr[right]){
            right--;
        }
        if(right == 0) return 0;
        int ans = right;
        for(int left = 0; left == 0 || arr[left]>=arr[left-1]; left++){
            while(right<n && arr[left]>arr[right]){
                right++;
            }
            ans = Math.min(ans, right - left -1);
        }
        return ans;
    }

    //TC = O(n), SC = O(1)
    private static int findLengthOfShortestSubarray1(int[] arr) {
        int i = 1, n = arr.length;
        if(n == 1) return 0;
        while(i<n && arr[i-1]<=arr[i]){
            i++;
        }
        if(i == n) return 0;
        int left = i-1;
        i = n-2;
        while(i>=0 && arr[i]<=arr[i+1]){
            i--;
        }
        int right = i+1, ans = n, j = right;
        i = 0;
        while(i<=left){
            while(j<n && arr[i]>arr[j]){
                j++;
            }
            ans = Math.min(ans, j-i-1);
            i++;
        }
        i = n-1; j = left;
        while(i>=right){
            while(j>=0 && arr[j]>arr[i]){
                j--;
            }
            ans = Math.min(ans, i-j-1);
            i--;
        }
        return ans;
    }
}
