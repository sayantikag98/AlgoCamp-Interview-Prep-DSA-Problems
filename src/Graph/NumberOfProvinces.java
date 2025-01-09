package Graph;
import java.util.*;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    private static class DSU{
        private final int[] parent, rank;
        private int cnt;

        DSU(int n){
            this.cnt = n;
            this.parent = new int[n+1];
            this.rank = new int[n+1];
            for(int i = 0; i<=n; i++){
                this.parent[i] = i;
            }
        }

        int find(int x){
            //iterative find
            int root = x;
            while(this.parent[root] != root){
                root = this.parent[root];
            }
            while(x != root){
                int temp = this.parent[x];
                this.parent[x] = root;
                x = temp;
            }
            return root;

            //recursive find
            // if(this.parent[x] == x) return x;
            // return this.parent[x] = find(this.parent[x]);
        }

        void union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            if(parentA != parentB){
                if(this.rank[parentA] < this.rank[parentB]){
                    this.parent[parentA] = parentB;
                }
                else if(this.rank[parentA] > this.rank[parentB]){
                    this.parent[parentB] = parentA;
                }
                else{
                    this.parent[parentA] = parentB;
                    this.rank[parentB]++;
                }
                cnt--;
            }
        }

        int countConnectedComponents(){
            return this.cnt;
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
        System.out.println(findCircleNumOptimized(isConnected));
        System.out.println(findCircleNumUsingDSU(isConnected));
    }


    private static int findCircleNumUsingDSU(int[][] isConnected) {
        //find no of connected components
        //TC = O(N^2), SC = O(N)
        DSU dsu = new DSU(isConnected.length);

        for(int i = 0; i<isConnected.length; i++){
            for(int j = 0; j<isConnected[i].length; j++){
                if(isConnected[i][j] == 1){
                    dsu.union(i+1, j+1);
                }
            }
        }

        return dsu.countConnectedComponents();
    }

    private static int findCircleNumOptimized(int[][] isConnected) {
        //find no of connected components
        List<List<Integer>> adjList = new ArrayList<>();

        //O(N)
        for(int i = 0; i<isConnected.length; i++){
            adjList.add(new ArrayList<>());
        }

        //O(N^2)
        for(int i = 0; i<isConnected.length; i++){
            for(int j = 0; j<isConnected[i].length; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        //SC = O(N), TC = O(N) + O(|N| + 2*|E|) where O(N+2E) for dfs and O(N) for for loop
        //extra space of adjacency list O(N+2E)
        //extra time of adjacency list O(N^2)
        int cnt = 0;
        boolean[] isVisited = new boolean[isConnected.length];
        for(int i = 0; i<isVisited.length; i++){
            if(!isVisited[i]){
                dfsUsingAdjacencyList(adjList, i, isVisited);
                cnt++;
            }
        }
        return cnt;
    }

    private static void dfsUsingAdjacencyList(List<List<Integer>> adjList, int start, boolean[] isVisited){
        isVisited[start] = true;
        for(var neighbor: adjList.get(start)){
            if(isVisited[neighbor]) continue;
            dfsUsingAdjacencyList(adjList, neighbor, isVisited);
        }
    }

    private static int findCircleNum(int[][] isConnected) {
        //find no of connected components

        int cnt = 0;
        boolean[] isVisited = new boolean[isConnected.length];
        for(int i = 0; i<isVisited.length; i++){
            if(!isVisited[i]){
                dfs(isConnected, i, isVisited);
                cnt++;
            }
        }
        return cnt;
    }

    private static void dfs(int[][] isConnected, int start, boolean[] isVisited){
        isVisited[start] = true;
        for(int i = 0; i<isConnected[start].length; i++){
            if(isConnected[start][i] == 0 || isVisited[i]) continue;
            dfs(isConnected, i, isVisited);
        }
    }
}
