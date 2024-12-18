package SearchingAndSorting.Sorting.IntervalBasedProblems;
import java.util.*;

//https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,6},{3,4},{4,7},{1,3},{3,8},{8,10},{4,8},{4,7}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        //TC = O(nlogn), SC = O(1)
        int n = intervals.length;
        if(n == 1) return 0;
        //sort in ascending order based on start
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));


        //j represents the previous interval that we are comparing with the current ith interval for overlap
        //lets say there are two intervals - ith current interval (si, ei) and jth previous interval (sj, ej), these intervals will
        //overlap if si < ej
        //whenever they overlap we have to two any one of the interval either the ith one or the jth one so increment the total count
        //we have to remove as minimum interval as possible and this will only happen if we remove the interval with more end time
        int i = 1, total = 0, j = 0;
        while(i<n){
            if(intervals[i][0] < intervals[j][1]){
                //ith and jth interval overlap so increment total count
                total++;
                //we can remove either the ith interval or the jth interval, but we remove the one with more end time to get the minimum count of interval removed
                if(intervals[j][1]>intervals[i][1]){
                    //here ith interval has less end time so remove the jth interval and update j for further checking
                    j=i;
                }
            }
            else{
                //ith interval and jth interval did not overlap
                j = i;
            }
            i++;
        }
        return total;
    }
}
