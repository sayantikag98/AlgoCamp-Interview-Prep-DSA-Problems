package Graph;
import java.util.*;

//https://leetcode.com/problems/is-graph-bipartite/
public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }

    private static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // sets[i] == 0 => unvisited
        // sets[i] == 1 => set 1
        // sets[i] == 2 => set 2
        int[] sets = new int [n];
        //set -> 1 or 2

        //TC = O(V) + O(V+2E), SC = O(V)
        for(int i = 0; i<n; i++){
            //every connected components should return true inorder to be bipartite
            if(sets[i] == 0 && !dfs(graph, i, sets, 1)) return false;
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int src, int[] sets, int set){
        //TC = O(V+2E), SC = O(V) -> height of the recursion tree max height can only be the max no of vertices
        sets[src] = set;
        for(var neighbors: graph[src]){
            if(sets[neighbors] == set) return false;
            if(sets[neighbors] == 0 && !dfs(graph, neighbors, sets, set == 1 ? 2 : 1)){
                return false;
            }
        }
        return true;
    }

    private static boolean bfs(int[][] graph, int src, int[] sets, int set){
        //TC = O(V+2E), SC = O(V)
        Queue<Integer> nodeList = new LinkedList<>();
        sets[src] = set; //initial node can belong to any set
        nodeList.offer(src);

        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            int currSet = sets[curr];
            for(var neighbors: graph[curr]){
                if(sets[neighbors] == currSet) return false;
                if(sets[neighbors] == 0){
                    //unvisited
                    nodeList.offer(neighbors);
                    sets[neighbors] = currSet == 1 ? 2 : 1;
                }
            }
        }

        return true;
    }
}
