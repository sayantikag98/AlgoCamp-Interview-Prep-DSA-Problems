package SlidingWindowLeetcode;
import java.util.*;

//https://leetcode.com/problems/sliding-subarray-beauty/
public class SlidingSubarrayBeauty {

    public static void main(String[] args) {
        int[] nums = {-4, 0, -1};
        int k = 2, x = 2;
        System.out.println(Arrays.toString(getSubarrayBeauty(nums, k, x)));
        System.out.println(Arrays.toString(getSubarrayBeautyUsingTreeMap(nums, k, x)));
        System.out.println(Arrays.toString(getSubarrayBeautyUsingFreqArrayConstraintOptimized(nums, k, x)));
        System.out.println(Arrays.toString(getSubarrayBeautyUsingFreqArrayConstraintOptimizedForNegativeNum(nums, k, x)));
    }

    private static int[] getSubarrayBeautyUsingFreqArrayConstraintOptimizedForNegativeNum(int[] nums, int k, int x) {
        //TC = O(k) + O(n-k+1)
        //SC = O(n-k+1)
        //This only works because constraint given in the question is -50<=nums[i]<=50
        //(v. imp) I only need to keep track of negative elements
        int n = nums.length;
        int[] freq = new int[50],
                ans = new int[n-k+1];

        for(int i = 0; i<k; i++){
            if(nums[i]<0) freq[nums[i]+50]++;
        }


        for(int i = k-1; i<n; i++){
            if(i>=k){
                int delEle = nums[i-k], addEle = nums[i];
                //deletion
                if(delEle<0) freq[delEle+50]--;
                //addition
                if(addEle<0) freq[addEle+50]++;
            }
            int count = 0;
            //TC = O(50) so constant time
            for(int j = 0; j<freq.length; j++){
                //Be careful with all these steps made many mistakes here
                if(freq[j]>0) count+=freq[j];
                if(x<=count){
                    ans[i-k+1] = j-50;
                    break;
                }
            }
        }
        return ans;
    }

    private static int[] getSubarrayBeautyUsingFreqArrayConstraintOptimized(int[] nums, int k, int x) {
        //TC = O(k) + O(n-k+1)
        //SC = O(n-k+1)
        //This only works because constraint given in the question is -50<=nums[i]<=50
        int n = nums.length;
        int[] freq = new int[101],
                ans = new int[n-k+1];

        for(int i = 0; i<k; i++){
            freq[nums[i]+50]++;
        }


        for(int i = k-1; i<n; i++){
            if(i>=k){
                int delEle = nums[i-k], addEle = nums[i];
                //deletion
                freq[delEle+50]--;
                //addition
                freq[addEle+50]++;
            }
            int count = 0;
            //TC = O(101) so constant time
            for(int j = 0; j<freq.length; j++){
                //Be careful with all these steps made many mistakes here
                if(freq[j]>0) count+=freq[j];
                if(x<=count){
                    ans[i-k+1] = Math.min(j-50, 0);
                    break;
                }
            }
        }
        return ans;
    }

    private static int[] getSubarrayBeautyUsingTreeMap(int[] nums, int k, int x) {
        int n = nums.length;
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int[] ans = new int[n-k+1];

        for(int i = 0; i<k; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = k-1; i<n; i++){
            if(i>=k){
                int delEle = nums[i-k], addEle = nums[i];
                //deletion
                freq.put(delEle, freq.get(delEle) - 1);
                if(freq.get(delEle) == 0) freq.remove(delEle);

                //addition
                freq.put(addEle, freq.getOrDefault(addEle, 0) + 1);
            }
            int count = 0;
            for(int key : freq.keySet()){
                count+=freq.get(key);
                if(x<=count){
                    ans[i-k+1] = Math.min(key, 0);
                    break;
                }
            }
        }
        return ans;
    }



    private static int[] getSubarrayBeauty(int[] nums, int k, int x) {

        /*
            TC = O(k) + O(klogk) + O((n-k+1) * (logk+k))
            O(k+klogk) only for initial window which can be considered much lesser than the second part
            TC ~ O((n-k+1) * (k+logk))
            if n is much larger than k,
            TC ~ O(n*(k+logk))
            TC ~ O(nk)
            which leads to TLE
         */


        int n = nums.length;
        /*
        public static int[] copyOf(int[] original, int newLength)

        Parameters:
            original - the array to be copied
            newLength - the length of the copy to be returned
        Returns:
            a copy of the original array, truncated or padded with zeros to obtain the specified length
        Throws:
            NegativeArraySizeException - if newLength is negative
            NullPointerException - if original is null
        */
        int[] copy = Arrays.copyOf(nums, k);
        /*
        public static void sort(int[] a, int fromIndex, int toIndex)

        Sorts the specified range of the array into ascending order. The range to be sorted extends from the index fromIndex, inclusive, to the index toIndex, exclusive.
        Parameters:
            a - the array to be sorted
            fromIndex - the index of the first element, inclusive, to be sorted
            toIndex - the index of the last element, exclusive, to be sorted
        Throws:
            IllegalArgumentException - if fromIndex > toIndex
            ArrayIndexOutOfBoundsException - if fromIndex < 0 or toIndex > a.length
        */

        Arrays.sort(copy); //TC = O(k*logk)
        int[] ans = new int[n-k+1];


        for(int i = k-1; i<n; i++){
            if(i>=k){
                int delEle = nums[i-k], addEle = nums[i];
                if(addEle != delEle){
                    int delEleIdx = Arrays.binarySearch(copy, delEle);
                    if(addEle < delEle){
                        /*
                        public static int binarySearch(int[] a, int fromIndex, int toIndex, int key)
                        Parameters:
                            a - the array to be searched
                            fromIndex - the index of the first element (inclusive) to be searched
                            toIndex - the index of the last element (exclusive) to be searched
                            key - the value to be searched for
                        Returns:
                            index of the search key, if it is contained in the array within the specified range; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element in the range greater than the key, or toIndex if all elements in the range are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
                        */
                        int addEleIdx = Arrays.binarySearch(copy, 0, delEleIdx+1, addEle);
                        if(addEleIdx>=0){
                            //if addEle is already there
                            for(int j = delEleIdx; j>addEleIdx; j--){
                                copy[j] = copy[j-1];
                            }
                        }
                        else{
                            //if addEle is not already there
                            //addEleIdx = (-(insertion point) - 1)

                            int insertionPt = addEleIdx*(-1) - 1;
                            //range of insertion point => 0 to delEleIdx+1
                            if(insertionPt == delEleIdx+1) insertionPt--;
                            for(int j = delEleIdx; j>insertionPt; j--){
                                copy[j] = copy[j-1];
                            }
                            copy[insertionPt] = addEle;
                        }
                    }
                    else{
                        int addEleIdx = Arrays.binarySearch(copy, delEleIdx, k, addEle);
                        if(addEleIdx >= 0){
                            //if addEle is already present
                            for(int j = delEleIdx; j<addEleIdx; j++){
                                copy[j] = copy[j+1];
                            }
                        }
                        else{
                            //if addEle is not already there
                            //addEleIdx = (-(insertion point) - 1)

                            int insertionPt = addEleIdx*(-1) - 1;
                            //range of insertion point => delEleIdx to n
                            insertionPt--; //MADE MISTAKE HERE V.V.V.V IMP
                            for(int j = delEleIdx; j<insertionPt; j++){
                                copy[j] = copy[j+1];
                            }
                            copy[insertionPt] = addEle;
                        }
                    }
                }
            }
            ans[i-k+1] = Math.min(0, copy[x-1]);
        }
        return ans;
    }
}
