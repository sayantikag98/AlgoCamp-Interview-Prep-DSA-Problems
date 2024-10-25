package ArraysAndHashMap;

//https://leetcode.com/problems/sum-of-unique-elements/
public class SumOfUniqueElements {

    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1,2,3,2}));
    }

    private static int sumOfUnique(int[] nums) {
        //TC = O(n), SC = O(n)
        if(nums.length == 1) return nums[0];
        int[] freq = new int[100];
        int sum = 0;
        for(int ele: nums){
            freq[ele-1]++;
            if(freq[ele-1] == 1) sum += ele;
            else if(freq[ele-1] == 2) sum-=ele;
        }
        return sum;
    }

}
