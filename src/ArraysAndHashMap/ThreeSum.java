package ArraysAndHashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSumUsingSortAndBinarySearchMostOptimized(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSumUsingHashMap(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSumUsingBinarySearch(new int[]{-1,0,1,2,-1,-4}));
    }

    private static List<List<Integer>> threeSumUsingSortAndBinarySearchMostOptimized(int[] nums) {
        //TC = O(n*n)
        //SC = O(1)
        int n = nums.length;
        List<List<Integer>> lans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<n-2; i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    lans.add(List.of(nums[i], nums[j], nums[k]));
                    while(j<k && nums[j] == nums[j+1]) j++;
                    j++;
                    while(j<k && nums[k] == nums[k-1]) k--;
                    k--;
                }
                else if(sum > 0){
                    //decrease sum
                    while(j<k && nums[k] == nums[k-1]) k--;
                    k--;
                }
                else{
                    while(j<k && nums[j] == nums[j+1]) j++;
                    j++;
                }
            }
            //either do continue at the top or this while loop
            // while(i<n-2 && nums[i] == nums[i+1]) i++;
        }
        return lans;
    }

    private static List<List<Integer>> threeSumUsingHashMap(int[] nums) {
        //TC = O(n*n)
        //SC = O(no of distinct numbers in the input array)
        // fix the first two number and find the third number using HashMap
        int n = nums.length;
        List<List<Integer>> lans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            hm.put(nums[i], i);
        }
        for(int i = 0; i<n-2; i++){
            //This if check will ensure that a triplet is not duplicated because the same number is ignored
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int targetSum = nums[i] * -1;
            //This if check will ensure that a triplet is not duplicated because the same number is ignored
            for(int j = i+1; j<n-1; j++){
                if(j!=i+1 && nums[j] == nums[j-1]) continue;
                int target = targetSum - nums[j];
                int idxFound = hm.getOrDefault(target, -1);
                if(idxFound >= j+1){
                    lans.add(Arrays.asList(nums[i], nums[j], nums[idxFound]));
                }
            }
        }
        return lans;
    }

    private static List<List<Integer>> threeSumUsingBinarySearch(int[] nums) {
        //TC = O(n*n*logn)
        //SC = O(1)
        // fix the first two number and find the third number using binary search because the array is sorted
        int n = nums.length;
        List<List<Integer>> lans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<n-2; i++){
            //This if check will ensure that a triplet is not duplicated because the same number is ignored
            if(i==0 || (nums[i] != nums[i-1])){
                int targetSum = nums[i] * -1;
                //This if check will ensure that a triplet is not duplicated because the same number is ignored
                for(int j = i+1; j<n-1; j++){
                    if(j == i+1 || (nums[j] != nums[j-1])){
                        int target = targetSum - nums[j];
                        int indexFound = binarySearch(nums, j+1, n-1, target);
                        if(indexFound != -1){
                            lans.add(Arrays.asList(nums[i], nums[j], nums[indexFound]));
                        }
                    }
                }
            }
        }
        return lans;
    }


    private static int binarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(target < nums[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
