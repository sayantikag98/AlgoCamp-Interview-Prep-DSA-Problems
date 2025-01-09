package Graph;

import java.util.*;

public class CycleDetectionUsingDFSAndBFS {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{1,6},{6,8},{7,5},{4,5},{2,3},{2,4},{1,2},{5,9},{5,10}};
        int source = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(var arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        boolean[] isVisited = new boolean[n+1];
        System.out.println(cycleDetectionUsingDFS(adjList, 1, -1, isVisited));
        System.out.println(cycleDetectionUsingBFS(adjList));
    }

    private static boolean cycleDetectionUsingBFS(List<List<Integer>> adjList){
        int src = 1;
        boolean[] isVisited = new boolean[adjList.size()];
        //instead of parent array, in the queue itself put a pair(node, parent)
        //check the code UnDirectedGraphCycle
        int[] parent = new int[adjList.size()];
        Queue<Integer> nodeList = new LinkedList<>();
        nodeList.offer(src);
        isVisited[src] = true;
        parent[src] = -1;
        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            for(var neighbors: adjList.get(curr)){
                if(isVisited[neighbors]){
                    if(neighbors != parent[curr]) return true;
                    else continue;
                }
                nodeList.offer(neighbors);
                isVisited[neighbors] = true;
                parent[neighbors] = curr;
            }
        }
        return false;
    }

    private static boolean cycleDetectionUsingDFS(List<List<Integer>> adjList, int src, int parent, boolean[] isVisited){
        //TC = O(V+E)
        isVisited[src] = true;
        for(var neighbors: adjList.get(src)){
            if(isVisited[neighbors]){
                if(neighbors != parent) return true; //cycle detection using dfs => when visited neighbor is not your parent then cycle present
                else continue;
            }
            if(cycleDetectionUsingDFS(adjList, neighbors, src, isVisited)){
                return true;
            }
        }
        return false;
    }

}
