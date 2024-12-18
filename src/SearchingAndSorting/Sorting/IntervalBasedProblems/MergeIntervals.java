package SearchingAndSorting.Sorting.IntervalBasedProblems;
import java.util.*;

//https://leetcode.com/problems/merge-intervals/description/


//class CustomComparator implements Comparator<int[]>{
//    @Override
//    public int compare(int[] a, int[] b){
//        if(a[0] < b[0]) return -1;
//        if(b[0] < a[0]) return 1;
//        if(a[1] == b[1]) return 0;
//        else if(a[1] < b[1]) return -1;
//        return 1;
//    }
//}

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{1,10}};
        int[][] ans = mergeUsingSortingOfStartOfTheInterval(intervals);
        for(var arr: ans){
            for(var ele: arr){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        intervals = new int[][]{{2,3},{4,5},{6,7},{1,10}};
        ans = mergeUsingSortingOfEndOfTheInterval(intervals);
        for(var arr: ans){
            for(var ele: arr){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        intervals = new int[][]{{2,3},{4,5},{6,7},{1,10}};
        ans = mergeUsingSortingOfStartOfTheInterval1(intervals);
        for(var arr: ans){
            for(var ele: arr){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mergeUsingSortingOfStartOfTheInterval1(int[][] intervals) {
        //TC = O(nlogn) [O(nlogn) for sorting and O(n) for merging], SC = O(no of merged intervals)
        ArrayList<int[]> lans = new ArrayList<>();

        //sorting is imp
        // WE CANT SORT A DOUBLE DIMENSIONAL ARRAY USING ARRAYS.SORT() DIRECTLY

        //sorted using start of interval in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        /*
        Lets say we have two intervals I1(s1, e1) and I2(s2, e2) where s2 >= s1
        if the intervals do not overlap then s2 > e1 otherwise it will overlap
        length of this two merged interval = (s1, Math.max(e1, e2))
         */
        int i = 0;
        while(i<intervals.length){
            int j = i+1;
            int[] inti = intervals[i];
            while(j<intervals.length){
                if(intervals[j][0]>inti[1]) break;
                inti[1] = Math.max(intervals[j][1], inti[1]);
                j++;
            }
            lans.add(inti);
            i = j;
        }
        return lans.toArray(new int[lans.size()][2]);
    }

    private static int[][] mergeUsingSortingOfStartOfTheInterval(int[][] intervals) {
        //TC = O(nlogn) [O(nlogn) for sorting and O(n) for merging], SC = O(no of merged intervals)
        ArrayList<int[]> lans = new ArrayList<>();

        //sorting is imp
        // WE CANT SORT A DOUBLE DIMENSIONAL ARRAY USING ARRAYS.SORT() DIRECTLY
        //Arrays.sort(intervals, (a, b) -> new CustomComparator().compare(a,b));

        //sorted using start of interval in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        /*
        Lets say we have two intervals I1(s1, e1) and I2(s2, e2) where s2 >= s1
        if the intervals do not overlap then s2 > e1 otherwise it will overlap
        length of this two merged interval = (s1, Math.max(e1, e2))
         */
        int i = 0;
        while(i<intervals.length){
            int j = i+1;
            //if you dont want to make changes on the input
//            int[] inti = Arrays.copyOf(intervals[i], intervals[i].length);

            int[] inti = intervals[i];
            while(j<intervals.length){
                if(intervals[j][0]>inti[1]) break;
                inti[1] = Math.max(intervals[j][1], inti[1]);
                j++;
            }
            lans.add(inti);
            i = j;
        }
        return lans.toArray(new int[lans.size()][2]);
    }

    private static int[][] mergeUsingSortingOfEndOfTheInterval(int[][] intervals){
        //TC = O(nlogn) [O(nlogn) for sorting and O(n) for merging], SC = O(no of merged intervals)
        //sorted using end of interval in descending order
        //why descending order sort consider this test case intervals = {{2,3},{4,5},{6,7},{1,10}}
        List<int[]> lans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(b[1], a[1]));

        /*
        Lets say we have two intervals I1(s1, e1) and I2(s2, e2) where e1 >= e2
        if the intervals do not overlap then e2 < s1 otherwise it will overlap
        length of this two merged interval = (min(s1, s2), e1)
         */

        int i = 0;
        while(i<intervals.length){
            int j = i+1;
            int[] inti = intervals[i];
            while(j < intervals.length){
                if(inti[0] > intervals[j][1]) break;
                inti[0] = Math.min(inti[0], intervals[j][0]);
                j++;
            }
            i = j;
            lans.add(inti);
        }
        return lans.toArray(new int[lans.size()][2]);
    }
}
