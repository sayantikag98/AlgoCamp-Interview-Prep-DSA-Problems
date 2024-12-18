package SearchingAndSorting.Sorting.IntervalBasedProblems;
import java.util.*;

//https://www.interviewbit.com/problems/meeting-rooms/
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] A = {{2,3},{0,30},{5,10},{7,9},{10,15}};
        System.out.println(solve(A));
        System.out.println(solveMoreOptimized(A));
    }

    private static int solveMoreOptimized(int[][] A) {
        //TC = O(nlogn), SC = O(n)
        int n = A.length;
        int[] start = new int [n], end = new int[n];
        for(int i = 0; i<n; i++){
            start[i] = A[i][0];
            end[i] = A[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        //curr denotes the total rooms in use
        //total denotes the total rooms allocated
        //j denotes that the first meeting that is going to end
        int j = 0, total = 1, curr = 1;
        for(int i = 1; i<n; i++){

            //deallocate the rooms which are done with meetings
            //first deallocate and then allocate

            if(start[i] >= end[j]){
                curr--;
                j++;
            }
            //whenever there is a meeting increment the rooms in use but before there check if there is a meeting ending or not
            curr++;
            //if the current room in use is greater than total allocated room do increase the total allocated rooms
            total = Math.max(total, curr);
        }
        return total;
    }

    private static int solve(int[][] A) {
        //TC = O(n^2), SC = O(n)
        int n = A.length;
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        List<Integer> rooms = new ArrayList<>();
        rooms.add(A[0][1]);
        int total = 1;
        // let's say there are two meetings m1(s1, e1) and m2(s2, e2) and they are sorted in ascending based on the start time so s1 <= s2,
        // these will overlap if s2<e1 and not overlap if s2 >= e1
        for(int i = 1; i<n; i++){
            boolean isAssigned = false;
            for(int j = 0; j<rooms.size(); j++){
                if(A[i][0] >= rooms.get(j)){
                    // this meeting does not overlap, so it can take place in this room only (reuse room)
                    rooms.set(j, A[i][1]);
                    isAssigned = true;
                    break;
                }
            }
            //this meeting has overlapped with every other previous meetings going on the conference rooms allocated till now
            if(!isAssigned){
                rooms.add(A[i][1]);
                total++;
            }
        }
        return total;
    }
}
