package ArraysAndHashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

//https://leetcode.com/problems/grid-illumination/

public class GridIllumination {
    public static void main(String[] args) {
        int[][] lamps = {{2,5},{4,2},{0,3},{0,5},{1,4},{4,2},{3,3},{1,0}}, queries = {{4,3},{3,1},{5,3},{0,5},{4,4},{3,3}};
        System.out.println(Arrays.toString(gridIllumination(6, lamps, queries)));
    }

    private static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //TC = O(10n), SC = O(5n)
        HashMap<Integer, Integer> row = new HashMap<>(), col = new HashMap<>(), sum = new HashMap<>(), diff = new HashMap<>();
        HashMap<List<Integer>, Integer> coor = new HashMap<>();
        for(int[] lamp: lamps){
            row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
            col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
            sum.put(lamp[0]+lamp[1], sum.getOrDefault(lamp[0]+lamp[1], 0) + 1);
            diff.put(lamp[1]-lamp[0], diff.getOrDefault(lamp[1]-lamp[0], 0) + 1);
            coor.put(List.of(lamp[0], lamp[1]), coor.getOrDefault(List.of(lamp[0], lamp[1]), 0) + 1);
        }
        int[] ans = new int[queries.length];

        for(int i = 0; i<queries.length; i++){
            int x = queries[i][0], y = queries[i][1];
            if(row.getOrDefault(x, 0)>0 || col.getOrDefault(y, 0)>0 || sum.getOrDefault(x+y, 0)>0 || diff.getOrDefault(y-x, 0)>0){
                ans[i] = 1;
            }
            for(int j = 0; j<3; j++){
                for(int k = 0; k<3; k++){
                    change(x+j-1, y+k-1, n, row, col, sum, diff, coor);
                }
            }
        }
        return ans;
    }

    private static void change(int x, int y, int n, HashMap<Integer, Integer> row, HashMap<Integer, Integer> col, HashMap<Integer, Integer> sum, HashMap<Integer, Integer> diff, HashMap<List<Integer>, Integer> coor){
        if(x>=0 && x<n && y>=0 && y<n){
            if(coor.containsKey(List.of(x, y))){
                int val = coor.get(List.of(x, y));
                if(row.get(x)>=val) row.put(x, row.get(x)-val);
                if(col.get(y)>=val) col.put(y, col.get(y)-val);
                if(sum.get(x+y)>=val) sum.put(x+y, sum.get(x+y)-val);
                if(diff.get(y-x)>=val) diff.put(y-x, diff.get(y-x)-val);
                coor.remove(List.of(x,y));
            }
        }

    }
}
