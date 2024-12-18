package SearchingAndSorting.Sorting;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {2,0,8,49,0,7};
        moveZeroes(arr);
        for(var ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    private static void moveZeroesOptimized(int[] nums) {
        //TC = O(n)
        int i = 0, j = 0;
        while(j<nums.length){
            if(nums[j] != 0){
                if(nums[i] == 0 && i != j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
            j++;
        }
    }
    private static void moveZeroes(int[] nums) {
        //TC = O(n^2)
        for(int i = 0; i<nums.length-1; i++){
            boolean isSwapped = false;
            for(int j = 0; j<nums.length-1-i; j++){
                if(nums[j] == 0 && nums[j+1] != 0){
                    isSwapped = true;
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            if(!isSwapped) return;
        }
    }

    private static void moveZeroes1(int[] nums) {
        //TC = O(n^2)
        for(int i = 1; i<nums.length; i++){
            int temp = nums[i], j;
            for(j = i-1; j>=0 && nums[j] == 0 && temp != 0; j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
    }
}
