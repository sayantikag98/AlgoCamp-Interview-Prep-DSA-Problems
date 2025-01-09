package Graph;
import java.util.*;

public class BreadthFirstSearchTraversal {
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
        System.out.println(bfs(adjList, source));
        System.out.println(bfsOfGraph(n+1, adjList, source));
    }

    private static ArrayList<Integer> bfsOfGraph(int V, List<List<Integer>> adj, int source) {
        // code here
        ArrayList<Integer> lans = new ArrayList<>();
        Queue<Integer> nodeList = new LinkedList<>();
        boolean[] visited = new boolean[V];
        nodeList.offer(source);
        visited[source] = true;
        lans.add(source);
        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            for(var neighbor: adj.get(curr)){
                if(!visited[neighbor]){
                    nodeList.offer(neighbor);
                    visited[neighbor] = true;
                    lans.add(neighbor);
                }
            }
        }
        return lans;
    }

    private static List<List<Integer>> bfs(List<List<Integer>> adjList, int src){
        //TC = O(|V|+|E|), SC = O(|V|)
        /*
        it is processing each node and each edge once
        the outer loop or the queue will have all the nodes
        and the inner loop in total will run for total degrees which is the total no of edges
         */
        Queue<Integer> nodeList = new LinkedList<>();
        boolean[] isVisited = new boolean[adjList.size()];
        List<List<Integer>> lans = new ArrayList<>();

        nodeList.offer(src);
        isVisited[src] = true;

        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            List<Integer> ans = new ArrayList<>();
            while(size-->0){
                int curr = nodeList.poll();
                ans.add(curr);
                List<Integer> neighbors = adjList.get(curr);
                for(var neighbor: neighbors){
                    if(isVisited[neighbor]) continue;
                    nodeList.offer(neighbor);
                    isVisited[neighbor] = true;
                }
            }
            lans.add(ans);
        }
        return lans;
    }
}
