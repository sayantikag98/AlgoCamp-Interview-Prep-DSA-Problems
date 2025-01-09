package Graph;
import java.util.*;

//https://leetcode.com/problems/find-eventual-safe-states/
public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(eventualSafeNodesUsingDFS(graph));
        System.out.println(eventualSafeNodesUsingBFS(graph));
    }

    private static List<Integer> eventualSafeNodesUsingBFS(int[][] graph) {
        //using topological sorting slightly modified
        //TC = O(V+E), SC = O(V+E)+O(V)
        int n = graph.length;
        //creating the adjacency list of all edges reversed
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        //outdegree or indegree of edges reversed
        int[] outDegree = new int[n];
        Queue<Integer> nodeList = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<graph[i].length; j++){
                adjList.get(graph[i][j]).add(i);
            }
            outDegree[i] = graph[i].length;
            if(outDegree[i] == 0){
                nodeList.offer(i);
            }
        }

        boolean[] list = new boolean[n];

        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            list[curr] = true;
            for(var neighbors: adjList.get(curr)){
                outDegree[neighbors]--;
                if(outDegree[neighbors] == 0){
                    nodeList.offer(neighbors);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(list[i]){
                ans.add(i);
            }
        }

        return ans;
    }


    private static List<Integer> eventualSafeNodesUsingDFS(int[][] graph) {
        //TC = O(V)+O(V+E), SC = O(V)
        int n = graph.length;
        //code quality improves if we have separate isVisited and path array instead of having one combined array marked
        int[] marked = new int[n];
        boolean[] isSafe = new boolean[n];
        for(int i = 0; i<n; i++){
            //need to check for all unvisited nodes
            if(marked[i] == 0){
                dfs(graph, i, marked, isSafe);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(isSafe[i]){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean dfs(int[][] graph, int src, int[] marked, boolean[] isSafe){
        //return true for safe nodes and return false for unsafe nodes
        marked[src] = 2;
        for(var neighbors: graph[src]){
            //neighbor node is a part of cycle or has a path to the cycle then src will never be a safe node
            if(marked[neighbors] == 2){
                return false;
            }
            //neighbor node is visited but safe then skip
            if(marked[neighbors] == 1){
                continue;
            }
            //if neighbor node is not safe, src is never safe
            if(!dfs(graph, neighbors, marked, isSafe)){
                return false;
            }
        }
        //src is a safe node if all its neighbors are safe
        marked[src] = 1;
        isSafe[src] = true;
        return true;
    }
}
