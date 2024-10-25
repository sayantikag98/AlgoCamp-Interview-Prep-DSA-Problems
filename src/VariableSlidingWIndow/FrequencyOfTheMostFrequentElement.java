package VariableSlidingWIndow;
import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int[] nums = {6,9,3,2,4,5,1,3}; int k = 5;
        System.out.println(maxFrequency(nums, k));
        System.out.println(maxFrequencyUsingSlidingWindow(nums, k));
        System.out.println(maxFrequencyUsingSlidingWindowMoreOptimized(nums, k));
    }

    private static int maxFrequencyUsingSlidingWindowMoreOptimized(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int i = 0, j = 0;
        while(j<nums.length){
            sum += nums[j];
            if((long)(j-i+1) * nums[j] - sum > k){
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return j-i;
    }

    private static int maxFrequencyUsingSlidingWindow(int[] nums, int k) {
        //TC = O(nlogn), SC = O(1)
        Arrays.sort(nums);
        long sum = 0;
        int maxFreq = 0;
        for(int i = 0, j = 0; j<nums.length; j++){
            sum+=(long)nums[j]*(j-i+1);
            //window invalid
            if(sum>k){
                sum-=(nums[j]-nums[i]);
                i++;
            }
            //window valid
            //will work with else also because when window became invalid length is max till now + 1 and increment i will anyway make length same as max len so far
            maxFreq = Math.max(maxFreq, j-i+1);

        }
        return maxFreq;
    }

    private static int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] suffix = new int[n+1];
        for(int i = n-1; i>=0; i--){
            suffix[i] = suffix[i+1] + nums[i];
        }

        int maxFreq = 1;
        for(int i = nums.length-1; i>=0; i--){
            //Once I get a max frequency as something I need to look for higher frequency
            //no need to iterate the array to get the same or less frequency so j starts from i-maxFreq
            //starting sum = nums[i]-nums[i] + nums[i]-nums[i-1] + .... + nums[i]-nums[i-maxFreq+1] = maxFreq*nums[i]-suffix[i-maxFreq+1]+suffix[i+1]
            //move j to the left till sum <= k
            int j = i-maxFreq, sum = maxFreq*nums[i]-suffix[i-maxFreq+1]+suffix[i+1];
            while(j>=0 && sum+nums[i]-nums[j]<=k){
                sum += nums[i] - nums[j];
                j--;
            }
            maxFreq = Math.max(maxFreq, i-j);
            //when i is less than maxFreq then that cannot contribute to answer
            if(i <= maxFreq) break;
        }
        return maxFreq;
    }
}
