package ArraysAndHashMap;

import java.util.HashMap;

//https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/description/

public class InterchangeableRectangles {
    public static void main(String[] args) {
        System.out.println(interchangeableRectangles(new int[][]{{4,8},{3,6},{10,20},{15,30}}));
        System.out.println(interchangeableRectanglesOptimizedApproach(new int[][]{{4,8},{3,6},{10,20},{15,30}}));
    }

    private static long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> hm = new HashMap<>();
        for(int[] ele: rectangles){
            double key = (double)ele[0]/ele[1];
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        long ans = 0;
        for(int count:hm.values()){
            ans+=((long)(count-1)*count)/2;
        }
        return ans;
    }

    private static long interchangeableRectanglesOptimizedApproach(int[][] rectangles) {
        HashMap<Double, Integer> hm = new HashMap<>();
        long ans = 0;
        for(int[] ele: rectangles){
            double key = (double)ele[0]/ele[1];
            int value = hm.getOrDefault(key, 0);
            ans+=value;
            hm.put(key, value + 1);
        }
        return ans;
    }

}
