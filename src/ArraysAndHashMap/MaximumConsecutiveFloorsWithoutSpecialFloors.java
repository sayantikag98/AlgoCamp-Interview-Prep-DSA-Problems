package ArraysAndHashMap;
import java.util.Arrays;

//https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
public class MaximumConsecutiveFloorsWithoutSpecialFloors {

    public static void main(String[] args) {
        System.out.println(maxConsecutive(2,9,new int[]{4,6}));
    }

    private static int maxConsecutive(int bottom, int top, int[] special) {
        //TC = O(nlogn), SC = O(1)
        Arrays.sort(special);
        int maxLength = 0, i = bottom;
        for(int j = 0; j<special.length; j++){
            int diff = special[j] - i;
            if(j!=0){
                diff--;
            }
            maxLength = Math.max(maxLength, diff);
            i = special[j];
        }
        return Math.max(maxLength, top-i);
    }
}
