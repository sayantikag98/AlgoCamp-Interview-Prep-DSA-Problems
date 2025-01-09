package Graph;
import java.util.*;

//https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[][] adjList = {{}, {3}, {3}, {}, {0,1}, {0,2}};
        for(var a: adjList){
            ArrayList<Integer> list = new ArrayList<>();
            for(var ele: a){
                list.add(ele);
            }
            adj.add(list);
        }
        System.out.println(topologicalSortUsingDFS(adj));
        System.out.println(topologicalSortUsingBFS(adj));
    }

    static ArrayList<Integer> topologicalSortUsingBFS(ArrayList<ArrayList<Integer>> adj) {
        //TC = O(V) + O(V+E), SC = O(V)
        //Kahn's Algorithm
        int n = adj.size();
        int[] inDegree = new int[n];

        for(var neighbors: adj){
            for(var ele: neighbors){
                inDegree[ele]++;
            }
        }

        ArrayList<Integer> lans = new ArrayList<>();
        bfs(adj, n, inDegree, lans);
        return lans;
    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int n, int[] inDegree, ArrayList<Integer> lans){
        Queue<Integer> nodeList = new LinkedList<>();

        for(int i = 0; i<n; i++){
            if(inDegree[i] == 0){
                nodeList.offer(i);
            }
        }

        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            lans.add(curr);
            for(var neighbors: adj.get(curr)){
                inDegree[neighbors]--;
                if(inDegree[neighbors] == 0){
                    nodeList.offer(neighbors);
                }
            }
        }
    }
    private static ArrayList<Integer> topologicalSortUsingDFS(ArrayList<ArrayList<Integer>> adj) {
        //TC = O(V) + O(V+E), SC = O(V)
        int n = adj.size();
        boolean[] isVisited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if(isVisited[i]) continue;
            dfs(adj, i, isVisited, st);
        }
        ArrayList<Integer> lans = new ArrayList<>();
        while(!st.empty()){
            lans.add(st.pop());
        }
        return lans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] isVisited, Stack<Integer> st){
        //works only for DAG -> no cycle present
        //if cycle present then detect cycle here and have return type boolean, check Course Schedule II using DFS technique
        isVisited[src] = true;
        for(var neighbors: adj.get(src)){
            if(isVisited[neighbors]) continue;
            dfs(adj, neighbors, isVisited, st);
        }
        //after exploring all the neighbors of src, neighbors of src will already be there on the stack
        st.push(src);
    }
}
