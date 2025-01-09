package Graph;
import java.util.*;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class CycleInADirectedGraph {
    public static void main(String[] args) {
        int n = 4, m = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[][] adjList = {{0, 1},{1, 2}, {2, 3}, {3, 3}};
        for(var a: adjList){
            ArrayList<Integer> list = new ArrayList<>();
            for(var ele: a){
                list.add(ele);
            }
            adj.add(list);
        }
        System.out.println(isCyclic(n, adj));
    }
    private static boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[n];

        for(var neighbors: adj){
            for(var ele: neighbors){
                inDegree[ele]++;
            }
        }

        ArrayList<Integer> lans = new ArrayList<>();
        bfs(adj, n, inDegree, lans);
        return lans.size() < n;
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
}
