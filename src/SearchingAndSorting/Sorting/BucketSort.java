package SearchingAndSorting.Sorting;
import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        double[] nums = {0.9,20.87,10.23,2.45,0.12};
        bucketSortMoreOptimized(nums);
        for(var ele: nums){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    private static void bucketSortMoreOptimized(double[] nums){
        int n = nums.length;
        List<List<Double>> buckets = new ArrayList<>(n);
        double maxEle = nums[0], minEle = nums[0];
        for(int i = 0; i<n; i++){
            maxEle = Math.max(maxEle, nums[i]);
            minEle = Math.min(minEle, nums[i]);
            buckets.add(new ArrayList<>());
        }
        for(var ele: nums){
            int index = (int) ((ele - minEle)/(maxEle - minEle)*n);
            if(index == n) index--;
            buckets.get(index).add(ele);
        }

        for(int i = 0; i<n; i++){
            if(buckets.get(i).size()>1){
                Collections.sort(buckets.get(i));
            }
        }

        int k = 0;
        for(var l: buckets){
            for(var d : l){
                nums[k++] = d;
            }
        }
    }

    private static void bucketSort(double[] nums){
        int n = nums.length;
        List<List<Double>> buckets = new ArrayList<>(n);
        for(int i = 0; i<n; i++){
            buckets.add(new ArrayList<>());
        }
        for(var ele: nums){
            int index = (int) (ele * n);
            buckets.get(index).add(ele);
        }

        for(int i = 0; i<n; i++){
            if(buckets.get(i).size()>1){
                Collections.sort(buckets.get(i));
            }
        }

        int k = 0;
        for(var l: buckets){
            for(var d : l){
                nums[k++] = d;
            }
        }
    }
}
