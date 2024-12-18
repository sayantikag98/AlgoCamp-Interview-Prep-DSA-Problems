package DailyChallenge;

//https://leetcode.com/problems/maximum-xor-for-each-query/description/
public class MaximumXORForEachQuery {
    public static void main(String[] args) {
        int[] ans = getMaximumXor(new int[]{0,1,2,2,5,7}, 3);
        for(int ele: ans){
            System.out.print(ele+" ");
        }
    }
    private static int[] getMaximumXor(int[] nums, int maximumBit) {
        //TC = O(n), SC = O(1)

        //take xor of all elements
        int xor = 0;
        for(int ele: nums){
            xor^=ele;
        }

        /*
        1. lets say nums = {1,2,3,4,5}
        xor of all elements from index 0 to index 2 (range_xor) = (xor of all elements from index 0 to 4) ^ (xor of all elements from index 3 to 4)

        2. to maximize range_xor ^ k, you will have to set all the bits of that number

        3. to set the bits you need to flip all the bits of range_xor

        4. to flip all the bits you need to take range_xor ^ mask of all ones

        5. mask of all ones = (1<<total bits) - 1 => (1<<maximumBit) - 1

        constraint given: 0 <= nums[i] < 2^maximumBit and k < 2^maximumBit
        from the above constraint we can deduce that total no of bits can be maximumBit only
        */
        int mask = (1<<maximumBit)-1, rxor = 0, n = nums.length;
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            ans[n-i-1] = xor^rxor^mask;
            rxor^=nums[i];
        }
        return ans;
    }

}
