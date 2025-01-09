package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTraversal {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{1,6},{6,8},{6,7},{7,5},{4,5},{2,3},{2,4},{1,2},{5,9},{5,10}};
        int source = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(var arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        List<Integer> ans = new ArrayList<>();
        dfs(adjList, source, ans, new boolean[adjList.size()]);
        System.out.println(ans);
    }

    private static void dfs(List<List<Integer>> adjList, int src, List<Integer> ans, boolean[] isVisited){
        isVisited[src] = true;
        ans.add(src);
        for(var neighbor: adjList.get(src)){
            if(isVisited[neighbor]) continue;
            dfs(adjList, neighbor, ans, isVisited);
        }
    }
}
