package Graph;

import java.util.ArrayList;
import java.util.List;

public class CountOfConnectedComponents {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{0,1},{0,3},{1,2},{2,3},{4,5},{4,6},{7,8}};
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(var arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        System.out.println(count(adjList, n));
    }

    private static int count(List<List<Integer>> adjList, int v){
        boolean[] isVisited = new boolean[v];
        int count = 0;
        for(int i = 0; i<v; i++){
            if(!isVisited[i]){
                dfs(adjList, i, isVisited);
                count++;
            }
        }
        return count;
    }

    private static void dfs(List<List<Integer>> adjList, int src, boolean[] isVisited){
        isVisited[src] = true;
        for(var neighbor: adjList.get(src)){
            if(!isVisited[neighbor]){
                dfs(adjList, neighbor, isVisited);
            }
        }
    }
}
