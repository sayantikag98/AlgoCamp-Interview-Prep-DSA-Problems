package Graph;
import java.util.*;

//https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1062626
public class DetectCycleInADirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0){
            int n = sc.nextInt();
            int e = sc.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for(int i = 0; i<e; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                Collections.addAll(edge, u, v);
                edges.add(edge);
            }
            System.out.println(detectCycleInDirectedGraphUsingSingleExtraArray(n, edges));
        }
    }

    private static boolean detectCycleInDirectedGraphUsingSingleExtraArray(int n, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(var edge: edges){
            adjList.get(edge.get(0)).add(edge.get(1));
        }

        // boolean[] isVisited = new boolean[n+1], path = new boolean[n+1];
        int[] marked = new int[n+1];

        for(int i = 1; i<=n; i++){
            if(marked[i] == 0 && dfs(adjList, i, marked)){
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adjList, int src, int[] marked){
        //marked[src] = 2 => visited + part of current path
        //marked[src] = 1 => visited + not part of current path
        //marked[src] = 0 => unvisited
        marked[src] = 2;
        for(var neighbors: adjList.get(src)){
            if(marked[neighbors] == 2) return true;
            if(marked[neighbors] == 1) continue;
            if(dfs(adjList, neighbors, marked)){
                return true;
            }
        }
        marked[src] = 1;
        return false;
    }
    private static boolean detectCycleInDirectedGraphUsing2ExtraArray(int n, ArrayList < ArrayList < Integer >> edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(var edge: edges){
            adjList.get(edge.get(0)).add(edge.get(1));
        }

        //TC = O(V)+O(V+E), SC = O(V)

        boolean[] isVisited = new boolean[n+1], path = new boolean[n+1];

        for(int i = 1; i<=n; i++){
            if(!isVisited[i] && dfs(adjList, i, isVisited, path)){
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adjList, int src, boolean[] isVisited, boolean[] path){
        isVisited[src] = path[src] = true;
        for(var neighbors: adjList.get(src)){
            if(isVisited[neighbors]){
                if(path[neighbors]) return true;
                continue;
            }
            if(dfs(adjList, neighbors, isVisited, path)){
                return true;
            }
        }
        path[src] = false;
        return false;
    }
}
