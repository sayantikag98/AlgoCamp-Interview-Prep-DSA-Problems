package Graph;
import java.util.*;

public class FindAllPathsFromSrcToDestination {
    public static void main(String[] args){
        int n = 7;
        int[][] edges = {{0,1},{1,2},{2,3},{0,3},{1,4},{4,5},{4,6},{5,6}};
        int source = 0;
        int destination = 5;
        System.out.println(validPathUsingAdjacencyList(n, edges, source, destination));
    }

    private static List<List<Integer>> validPathUsingAdjacencyList(int n, int[][] edges, int src, int dest){
        List<List<Integer>> lans = new LinkedList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(var arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        dfs(adjList, src, dest, new boolean[n], new LinkedList<>(), lans);
        return lans;
    }

    private static void dfs(List<List<Integer>> adjList, int src, int dest, boolean[] isVisited, List<Integer> ans, List<List<Integer>> lans){
        if(src == dest){
            ans.add(dest);
            lans.add(new ArrayList<>(ans));
            ans.removeLast(); //undo when returning
            return;
        }

        //finding all paths backtracking is important

        isVisited[src] = true;
        ans.add(src);
        for(var neighbor: adjList.get(src)){
            if(isVisited[neighbor]) continue;
            dfs(adjList, neighbor, dest, isVisited, ans, lans);
        }
        //here unmarking the node as visited is important because that particular node may be a part of another path
        isVisited[src] = false;
        ans.removeLast();
    }
}
