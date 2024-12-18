package RecursionAndBacktracking;
import java.util.*;

//https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
public class GFGMColoringProblem {
    public static void main(String[] args) {
        int v = 3, m = 1;
        List<int[]> edges = new ArrayList<>();
        edges.add(new int []{0,1});
        System.out.println(graphColoring(v, edges, m));
    }
    private static boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int row = edge[0];
            int col = edge[1];
            adj.get(row).add(col);
            adj.get(col).add(row);
        }
        return helper(v, 0, m, adj, new int[v]);

    }

    private static boolean helper(int v, int ind, int m, List<List<Integer>> adj, int[] ans){
        //TC = O(m^v), SC = O(v^2)
        if(ind == v){
            return true;
        }
        for(int i = 1; i<=m; i++){
            if(isValid(adj.get(ind), ans, i)){
                ans[ind] = i;
                if(helper(v, ind+1, m, adj, ans)) return true;
                ans[ind] = 0;
            }
        }
        return false;
    }


    private static boolean isValid(List<Integer> adj, int[] ans, int color){
        for(int ele: adj){
            //ele -> each of the adjacents
            if(ans[ele] == color) return false;
        }
        return true;
    }
}
