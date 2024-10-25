package ArraysAndHashMap;
import java.util.*;

//https://leetcode.com/problems/4sum/description/
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        //TC = O(n^3), SC = O(1)
        int n = nums.length;
        List<List<Integer>> lans = new ArrayList<>();
        if(n<4) return lans;
        Arrays.sort(nums);
        for(int i = 0; i<n-3; i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<n-2; j++){
                if(j!=i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = n-1;
                while(k<l){
                    //individually typecast to long
                    /*
                        //Constraint given: -10^9 <= nums[i] <= 10^9
                        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};

                        //Incorrect way:
                        long sum = nums[0] + nums[1] + nums[2] + nums[3];
                        //sum = -294967296

                        Here sum is equal to -294967296 instead of 4*10^9 because nums[i] are
                        integers and 4 integers when added will lead to overflow. 4*10^9 is
                        outside the range of int datatype.


                        //Correct way:
                        long sum = (long)nums[0] + (long)nums[1] + (long)nums[2] + (long)nums[3];
                        //sum = 4000000000

                        //Another correct way:
                        long sum = nums[0] + nums[1];
                        sum += nums[2];
                        sum += nums[3];
                        //sum = 4000000000
                     */
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];  ///// MADE MISTAKE HERE
                    if(sum == target){
                        lans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        while(k<l && nums[k] == nums[k+1]) k++;
                        while(k<l && nums[l] == nums[l-1]) l--;
                        k++;
                        l--;
                    }
                    else if(sum > target){
                        //decrease sum
                        while(k<l && nums[l] == nums[l-1]) l--;
                        l--;
                    }
                    else{
                        //increase sum
                        while(k<l && nums[k] == nums[k+1]) k++;
                        k++;
                    }
                }
            }
        }
        return lans;
    }
}
