package SearchingAndSorting.Sorting.IntervalBasedProblems;
import java.util.*;

//https://leetcode.com/problems/insert-interval/description/
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] ans = insert(intervals, newInterval);
        for(var arr: ans){
            for(var ele: arr){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        //TC = O(n), SC = O(no of merged intervals)
        List<int[]> lans = new ArrayList<>();
        int i = 0;
        while(i<intervals.length && intervals[i][1] < newInterval[0]){
            lans.add(Arrays.copyOf(intervals[i], intervals[i].length));
            i++;
        }
        lans.add(newInterval);

        while(i < intervals.length){
            int[] currentInterval = Arrays.copyOf(intervals[i], intervals[i].length);
            int[] lastInterval = lans.getLast();
            if(currentInterval[0]<=lastInterval[1]){
                lastInterval[0] = Math.min(lastInterval[0], currentInterval[0]);
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            }
            else{
                lans.add(currentInterval);
            }
            i++;
        }

        return lans.toArray(new int[lans.size()][]);
    }
}
