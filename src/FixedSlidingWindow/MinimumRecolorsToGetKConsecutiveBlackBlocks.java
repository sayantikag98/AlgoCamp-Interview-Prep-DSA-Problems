package FixedSlidingWindow;
//https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
    }
    private static int minimumRecolors(String blocks, int k) {
        int minCount = k, count = 0;
        for(int i = 0; i<blocks.length(); i++){
            if(i>=k && blocks.charAt(i-k) == 'W') count--;
            if(blocks.charAt(i) == 'W') count++;
            if(i>=k-1) minCount = Math.min(minCount, count);
        }
        return minCount;
    }
}
