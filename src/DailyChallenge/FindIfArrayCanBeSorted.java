package DailyChallenge;

public class FindIfArrayCanBeSorted {
    public static void main(String[] args) {
        int[] nums = {8,4,2,30,15};
        System.out.println(canSortArray(nums));
        System.out.println(canSortArrayWithoutExtraSpace(nums));
        System.out.println(canSortArrayUsingForwardAndReversePass(nums));
        System.out.println(canSortArrayMostOptimized(nums));
    }

    private static boolean canSortArrayMostOptimized(int[] nums) {
        /*
        Given its implementation, the method consists of six O(1) statements performed in sequence, so it's O(1).
        https://stackoverflow.com/a/44250362
        */

        /*
        TC = O(n), SC = O(1)
        Intuition:
            1. given input array can be spiltted into different segments each segment having same number of set bits
            2. keep track of the minimum and the maximum value of these segments
            3. within the segment we can swap any number of time to sort the segment anyways so we dont need to sort it explicitly
            4. what we need to make sure is min value of the current segment can only be >= max value of the prev segment so that the segments are in order and
            also same set bit number can only be swapped in order to sort
        */
        int minVal = nums[0], maxVal = nums[0], prevMax = Integer.MIN_VALUE;
        for(int i = 1; i<nums.length; i++){
            //segment having same no of set bits
            if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i-1])){
                minVal = Math.min(minVal, nums[i]);
                maxVal = Math.max(maxVal, nums[i]);
            }
            //different segment having a different value of set bits
            else{
                //previous max (prevMax) should be <= current min (minVal)
                if(prevMax > minVal) return false;
                prevMax = maxVal;
                minVal = nums[i];
                maxVal = nums[i];
            }
        }
        //MADE MISTAKE HERE --- VVVV.IMP (making this mistake every time)
        if(prevMax > minVal) return false;
        return true;
    }

    private static boolean canSortArrayUsingForwardAndReversePass(int[] nums) {
        //pass the array twice one time from left to right to push the maximum of every segment with equal no of set bits at the end of that segment
        //and the second in reverse direction from right to left to push the minimum of every segment with equal no of set bits at the start of that segment
        int n = nums.length;
        for(int i = 0; i<n-1; i++){
            if(nums[i]>nums[i+1]){
                if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i+1])){
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
                //once the no of set bits of a mismatch pair are not equal it will never be sorted
                else return false;
            }
        }

        for(int i = n-1; i>0; i--){
            if(nums[i]<nums[i-1]){
                if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i-1])){
                    int temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                }
                //once the no of set bits of a mismatch pair are not equal it will never be sorted
                else return false;
            }
        }
        return true;
    }

    private static boolean canSortArrayWithoutExtraSpace(int[] nums) {
        //bubble sort
        for(int j = nums.length-1; j>0; j--){
            boolean isSorted = true;
            for(int i = 0; i<j; i++){
                if(nums[i]>nums[i+1]){
                    isSorted = false;
                    //MADE MISTAKE Integer.bitCount[nums[i]] and not Integer.bitCount[i]
                    if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i+1])){
                        int temp = nums[i];
                        nums[i] = nums[i+1];
                        nums[i+1] = temp;
                    }
                    //once the no of set bits of a mismatch pair are not equal it will never be sorted
                    else return false;
                }
            }

            //if there is no mismatch found in the inner iterations then the array has been sorted
            if(isSorted) return true;
        }
        return true;
    }
    private static boolean canSortArray(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;


        //store the no of set bits in the array
        //if i is even -> no of set bits of i/2
        //if i is odd -> (no of set bits of i/2) + 1
        int[] noOfBits = new int[257];
        for(int i = 1; i<noOfBits.length; i++){
            noOfBits[i] = noOfBits[i/2];
            if((i&1) == 1) noOfBits[i]++;
        }

        //like bubble sort
        for(int j = nums.length-1; j>0; j--){
            boolean isSorted = true;
            for(int i = 0; i<j; i++){
                if(nums[i]>nums[i+1]){
                    isSorted = false;
                    //MADE MISTAKE noOfBits[nums[i]] and not noOfBits[i]
                    if(noOfBits[nums[i]] == noOfBits[nums[i+1]]){
                        int temp = nums[i];
                        nums[i] = nums[i+1];
                        nums[i+1] = temp;
                    }
                    //once the no of set bits of a mismatch pair are not equal it will never be sorted
                    else return false;
                }
            }

            //if there is no mismatch found in the inner iterations then the array has been sorted
            if(isSorted) return true;
        }
        return true;
    }
}
