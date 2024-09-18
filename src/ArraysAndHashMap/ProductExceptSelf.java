package ArraysAndHashMap;//import java.util.Arrays;


//https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] ans = productExceptSelfWithTwoArray(new int[] {1,2,3,4});
//        System.out.println(Arrays.toString(ans));

        for(int i:ans){
            System.out.print(i+" ");
        }
    }


    private static int[] productExceptSelfWithTwoArray(int[] nums) {
        //WITH PREFIX AND SUFFIX ARRAY
        int n = nums.length;
        int[] prefix = new int[n], suffix = new int[n], ans = new int[n];

        //to fill the prefix and suffix array
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for(int i = 1; i<n; i++){
            prefix[i] = nums[i] * prefix[i-1];
            suffix[n-i-1] = nums[n-i-1] * suffix[n-i];
        }

        //calculation of ans from prefix and suffix array
        ans[0] = suffix[1];
        ans[n-1] = prefix[n-2];

        for(int i = 1; i<n-1; i++){
            ans[i] = prefix[i-1] * suffix[i+1];
        }

        return ans;
    }

    private static int[] productExceptSelfWithOnlySuffixArray(int[] nums){
        //WITH ONLY SUFFIX ARRAY
        int n = nums.length, prefixMul = 1;
        int[] ans = new int[n], suffix = new int[n];
        suffix[n-1] = 1;

        for(int i = n-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        ans[0] = suffix[0];

        for(int i = 1; i<n; i++){
            prefixMul *= nums[i-1];
            ans[i] = prefixMul * suffix[i];
        }

        return ans;
    }

    private static int[] productExceptSelfWithoutPrefixAndSuffixArray(int[] nums) {
        //WITHOUT PREFIX AND SUFFIX ARRAY
        int n = nums.length, prefixMul = 1;
        int[] ans = new int[n];
        ans[n-1] = 1;

        for(int i = n-2; i>=0; i--){
            ans[i] = ans[i+1] * nums[i+1];
        }

        for(int i = 1; i<n; i++){
            prefixMul *= nums[i-1];
            ans[i] *= prefixMul;
        }

        return ans;
    }
}
