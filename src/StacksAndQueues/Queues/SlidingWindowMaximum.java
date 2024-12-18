package StacksAndQueues.Queues;
import java.util.*;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindowAnotherImplementation(nums, k)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        //TC = O(n), SC = O(n)
        //always maintain the maximum at the head of the deque
        //so when inserting the element index check whether there are element index whose value is less than or equal the value of the index to be inserted
        //if that's the case remove all those indices
        //why to remove all those indices whose value is smaller or equal that the incoming index element - this is because it can never be the maximum when the greater
        //element is present in the window so remove that and maintain the maximum at the head
        //when the incoming index element is smaller than the element whose index is at the rear end then we can add that index
        //because that element might be the maximum for a future window when our current maximum is outside the window
        int n = nums.length;
        Deque<Integer> d = new LinkedList<>();

        int[] ans = new int[n-k+1];

        int j = 0;
        for(int i = 0; i<n; i++){
            if(i>=k) ans[j] = nums[d.peekFirst()];
            //adding elements in the window
            while(!d.isEmpty() && nums[d.peekLast()] <= nums[i]){
                d.pollLast();
            }
            d.offerLast(i);

            //removing elements from window after window length = k
            if(i >= k){
                if(d.peekFirst() == j){
                    d.pollFirst();
                }
                j++;
            }
        }
        ans[j] = nums[d.peekFirst()];
        return ans;

    }

    private static int[] maxSlidingWindowAnotherImplementation(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> d = new LinkedList<>();

        int[] ans = new int[n-k+1];

        //first window
        int i;
        for(i = 0; i<k; i++){
            while(!d.isEmpty() && nums[d.peekLast()] <= nums[i]){
                d.pollLast();
            }
            d.offerLast(i);
        }

        ans[0] = nums[d.peekFirst()];

        //rest of the window
        int j = 0;
        while(i<n){
            //element to be removed from window
            if(d.peekFirst() == j){
                d.pollFirst();
            }
            while(!d.isEmpty() && nums[d.peekLast()] <= nums[i]){
                d.pollLast();
            }
            d.offerLast(i);
            i++;
            j++;
            ans[j] = nums[d.peekFirst()];
        }

        return ans;

    }
}
