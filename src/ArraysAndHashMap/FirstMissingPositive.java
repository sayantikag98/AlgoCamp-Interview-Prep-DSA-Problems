package ArraysAndHashMap;

//https://leetcode.com/problems/first-missing-positive/description/

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositiveUsingIndexAsHashKey(new int[]{1,2,0}));
        System.out.println(firstMissingPositiveUsingCyclicSort(new int[]{1,2,0}));
    }

    private static int firstMissingPositiveUsingIndexAsHashKey(int[] nums) {
        //TC = O(n), SC = O(1)
        int n = nums.length;
        //check if 1 is present in the input array or not, if not present then 1 is the answer
        boolean isOnePresent = false;
        for(int i:nums){
            if(i == 1) {
                isOnePresent = true;
                break;
            }
        }
        if(!isOnePresent) return 1;


        //answer will be between 1 to n+1
        //so any number >n, 0, and negative numbers will not be considered for answer computation
        // so mark those as 1

        for(int i = 0; i<n; i++){
            if(nums[i]>n || nums[i]<=0) nums[i] = 1;
        }

        // mark nums[Math.abs(nums[i]) - 1] *= -1 if its not already negative

        for(int i = 0; i<n; i++){
            int idx = Math.abs(nums[i]) - 1;  //-1 to make zero based indexing
            if(nums[idx] > 0) nums[idx] *= -1;
        }


        //iterate from left and check which index has a positive value, if there is a positive value then that index+1 is the answer otherwise if
        //all the index has negative values then all numbers from 1 to n is present in the array so n+1 is the answer

        for(int i = 0; i<n; i++){
            if(nums[i]>0) return i+1;
        }

        return n+1;

    }


    private static int firstMissingPositiveUsingCyclicSort(int[] nums) {
        //TC = O(n), SC = O(1)
        //Using cyclic sort
        int n = nums.length;

        for(int i = 0; i<n; i++){
            int correctIndex = nums[i] - 1;
            while(nums[i]>0 && nums[i]<=n && nums[correctIndex] != nums[i]){
                swap(nums, correctIndex, i);
                correctIndex = nums[i] - 1;
            }
        }

        for(int i = 0; i<n; i++){
            if(nums[i] != i+1) return i+1;
        }

        return n+1;

    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
