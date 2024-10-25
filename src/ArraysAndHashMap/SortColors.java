package ArraysAndHashMap;
import java.util.Arrays;
//https://leetcode.com/problems/sort-colors/description/

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2,1,0,1,2,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (j<=k){
            if(nums[j] == 0){
                nums[j] = nums[i];
                nums[i] = 0;
                i++;
                if(j<i) j = i;
            }
            else if(nums[j] == 1) j++;
            else{
                nums[j] = nums[k];
                nums[k] = 2;
                k--;
            }
        }
    }
}
