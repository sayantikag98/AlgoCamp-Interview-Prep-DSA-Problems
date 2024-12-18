package SearchingAndSorting.Sorting.IntervalBasedProblems;
import java.util.*;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,5}};
        System.out.println(canAttend(intervals));
    }

    private static boolean canAttend(int[][] intervals){
        int n = intervals.length;
        if(n < 2) return true;
        //sort based on starting time in ascending order

        //if the number of meeting rooms required is one or there are no meetings which are overlapping then a person can attend all the meetings
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i = 1; i<n; i++){
            //interval 1 => s1, e1 and interval 2 => s2, e2 so the intervals will overlap if s2 < e1
            if(intervals[i][0] < intervals[i-1][0]) return false;
        }
        return true;
    }
}
