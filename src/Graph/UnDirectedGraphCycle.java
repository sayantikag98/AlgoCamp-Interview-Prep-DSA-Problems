package Graph;
import java.util.*;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class UnDirectedGraphCycle {
    private static record Pair(int first, int second) {}

    private static class DSU{
        int[] parent, rank;
        DSU(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i<n; i++){
                this.parent[i] = i;
            }
        }

        int find(int x){
            if(this.parent[x] == x) return x;
            return this.parent[x] = find(this.parent[x]);
        }

        boolean union(int a, int b){
            a = find(a);
            b = find(b);
            if(a == b) return true;
            if(this.rank[a] < this.rank[b]){
                this.parent[a] = b;
            }
            else{
                this.parent[b] = a;
                if(this.rank[a] == this.rank[b]){
                    this.rank[a]++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,4},{1,2},{1,4},{2,3},{3,4}};
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(var arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        System.out.println(isCycleUsingBFSOrDFS(adjList));
        System.out.println(isCycleUsingDSU(adjList));
    }

    private static boolean isCycleUsingDSU(ArrayList<ArrayList<Integer>> adj) {
        //TC = O(N+2E), SC = O(N)
        int n = adj.size();
        DSU dsu = new DSU(n);
        //Set used for unique counting of union(a,b) and not double counting for union(a,b) and union(b,a)
        Set<String> isVisited = new HashSet<>();
        for(int i = 0; i<n; i++){
            for(var neighbors: adj.get(i)){
                if(isVisited.contains(i+","+neighbors)) continue;
                isVisited.add(neighbors+","+i);
                if(dsu.union(i, neighbors)) return true;
            }
        }
        return false;
    }

    private static boolean isCycleUsingBFSOrDFS(ArrayList<ArrayList<Integer>> adj) {
        // TC = O(N+2E) + O(N) where 2E for undirected graph and O(N+2E) for bfs and O(N) for running for loop for checking multiple connected components
        //SC = O(N) for queue and isVisited array
        boolean[] isVisited = new boolean[adj.size()];
        for(int i = 0; i<isVisited.length; i++){
            if(!isVisited[i]){
//                if(bfs(adj, i, -1, isVisited)) return true;
                if(dfs(adj, i, -1, isVisited)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int parent, boolean[] isVisited){
        isVisited[src] = true;
        for(var neighbors: adj.get(src)){
            if(isVisited[neighbors]){
                if(neighbors == parent) continue;
                return true;
            }
            if(dfs(adj, neighbors, src, isVisited)) return true;
        }
        return false;
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, int parent, boolean[] isVisited){
        Queue<Pair> nodeList = new LinkedList<>();
        nodeList.offer(new Pair(src, parent));
        isVisited[src] = true;
        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            for(var neighbors: adj.get(curr.first())){
                if(isVisited[neighbors]){
                    if(neighbors == curr.second()){
                        //neighbor is a parent
                        continue;
                    }
                    else{
                        //neighbor is visited but not a parent then its a cycle
                        return true;
                    }
                }
                nodeList.offer(new Pair(neighbors, curr.first()));
                isVisited[neighbors] = true;
            }
        }
        return false;
    }
}
