package FixedSlidingWindow;

//https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-group-all-1s-together2451/1
//https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/description/ (Leetcode premium)
public class MinimumSwapsToGroupAllOnesTogether {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{1, 0, 1, 0, 1}));
    }
    private static int minSwaps(int[] arr) {
        // Complete the function
        int k = 0;
        for(int ele: arr){
            if(ele == 1) k++;
        }

        if(k==0) return -1;

        int ans = k, count = 0;
        for(int i = 0; i<arr.length; i++){
            if(i >= k && arr[i-k] == 0) count--;
            if(arr[i] == 0) count++;
            if(i >= k-1) ans = Math.min(ans, count);
        }
        return ans;
    }
}
