package Graph;
import java.util.*;

//https://leetcode.com/problems/find-if-path-exists-in-graph/
public class FindIfPathExistsInGraph {
    public static void main(String[] args){
        int n = 7;
        int[][] edges = {{0,1},{1,2},{2,3},{0,3},{1,4},{4,5},{4,6},{5,6}};
        int source = 0;
        int destination = 5;
        System.out.println(validPathUsingAdjacencySet(n, edges, source, destination));
        System.out.println(validPathUsingAdjacencyList(n, edges, source, destination));
    }

    private static boolean validPathUsingAdjacencyList(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(var arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }

        return dfs1(adjList, source, destination, new boolean[n]);
    }

    private static boolean dfs1(List<List<Integer>> adjList, int source, int destination, boolean[] isVisited){
        //TC = O(|V| + |E|) => all nodes and edges are read exactly once

        //one node will always be present once in a path and we need only a path, so we don't need to mark it as unvisited when returning (no need to backtrack)
        if(source == destination) return true;

        isVisited[source] = true;

        List<Integer> neighbors = adjList.get(source);

        for(var neighbor: neighbors){
            if(isVisited[neighbor]) continue;
            if(dfs1(adjList, neighbor, destination, isVisited)) return true;
        }

        return false;
    }

    private static boolean validPathUsingAdjacencySet(int n, int[][] edges, int source, int destination) {
        List<Set<Integer>> adjSet = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjSet.add(new HashSet<>());
        }

        for(var arr: edges){
            adjSet.get(arr[0]).add(arr[1]);
            adjSet.get(arr[1]).add(arr[0]);
        }

        return dfs(adjSet, source, destination, new boolean[n]);
    }

    private static boolean dfs(List<Set<Integer>> adjSet, int source, int destination, boolean[] isVisited){
        if(source == destination || adjSet.get(source).contains(destination)) return true;

        var it = adjSet.get(source).iterator();

        isVisited[source] = true;

        while(it.hasNext()){
            int neighbor = it.next();
            if(isVisited[neighbor]) continue;

            if(dfs(adjSet, neighbor, destination, isVisited)) return true;
        }

        return false;
    }
}
