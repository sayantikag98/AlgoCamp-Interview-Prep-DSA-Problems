package ArraysAndHashMap;
import java.util.Arrays;

//https://leetcode.com/problems/valid-triangle-number/description/
public class ValidTriangleNumber {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{4,2,3,4}));
    }
    private static int triangleNumber(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        Arrays.sort(nums);
        int valid = 0;
        for(int i = 0; i<n-2; i++){
            int k = i+2;
            for(int j = i+1; j<n-1; j++){
                if(k <= j){
                    k = j+1;
                }
                while(k<n){
                    if(nums[i]+nums[j]>nums[k] && nums[j]+nums[k]>nums[i] && nums[i]+nums[k]>nums[j]){
                        k++;
                    }
                    else{
                        valid+=k-j-1;
                        break;
                    }
                }
                if(k == n){
                    valid+=k-j-1;
                }
            }
        }
        return valid;
    }
}
