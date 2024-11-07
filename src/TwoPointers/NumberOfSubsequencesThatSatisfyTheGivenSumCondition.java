package TwoPointers;
import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public static void main(String[] args) {
        int[] nums = {2,3,3,4,5,7};
        int target = 10;
        System.out.println(numSubseq(nums, target));
    }
    private static int numSubseq(int[] nums, int target) {
        //TC = O(nlogn), SC = O(n)
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = n-1, mod = 1000000007, count = 0;
        //precomputing power is very imp otherwise throwing tle
        //Math.pow() cannot handle the given constraints
        int[] power = new int[n];
        powerCompute(2, n, mod, power);
        while(l<=r){
            if(nums[l]+nums[r] <= target){
                /*
                    why power[r-l] needs to be added?
                        nums[l] + nums[r] <= target, if this condition is valid then we need to find the number of subsequences within the given range(l to r both inclusive) that meets the given condition.
                        As the array is sorted so in the given range (nums[l], nums[l+1], nums[l+2] ....... nums[r-1], nums[r]) nums[l] is the minimum and nums[r]
                        is the maximum, so if nums[l]+nums[r]<=target then we can also say that nums[l] added with any number will also be <= target, so any subsequence
                        having nums[l] will also satisfy the given condition. The number of subsequence having nums[l] is 2^(n-1) where n is the length of subsequence here being
                        n = r-l+1 so 2^(n-1) = 2^(r-l+1-1) = 2^(r-l). How number of subsequence having any particular number in the given range is 2^(n-1)? Lets say the range is [4,5]
                        the total non empty subsequences are [4], [5], [4,5], the number of subsequences having 4 are 2 and having 5 are also 2 which is 2^(n-1) = 2^(2-1) = 2^1 = 2
                */
                // count += power[r-l];
                // count %= mod;
                count = (count + power[r-l]) % mod; //either do the above commented one or this, both equivalent
                // doing this count += power[r-l] % mod; is wrong

                //if the condition satisfy, sum <= target then increment l to increase the sum
                l++;
            }
            else{
                //if the condition does not satisfy, sum > target then decrement r to decrease the sum
                r--;
            }
        }
        return count;
    }


    private static void powerCompute(int base, int exponent, int mod, int[] power){
        power[0] = 1;
        for(int k = 1; k<exponent; k++){
            // power[k] = base * power[k-1];
            // power[k] %= mod;
            power[k] = base * power[k-1] % mod; //either do the above commented one or this, both equivalent
        }
    }
}
