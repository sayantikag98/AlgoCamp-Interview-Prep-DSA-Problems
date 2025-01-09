package Graph;
import java.util.*;

public class ShortestPathUsingBFS {
    public static void main(String[] args) {
        int v = 7;
        int[][] edges = {{1,2},{1,4},{2,3},{2,5},{3,4},{5,6},{5,7},{6,7}};
        int p = 6;
        int q = 2;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=v; i++){
            adjList.add(new ArrayList<>());
        }

        for(var edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] isVisited = new boolean[v+1];
        int[] distance = new int[v+1];
        shortestPathOfAllNodes(adjList, p, isVisited, distance);
        System.out.println(Arrays.toString(distance));
    }

    private static void shortestPathOfAllNodes(List<List<Integer>> adjList, int p, boolean[] isVisited, int[] distance){
        Queue<Integer> nodeList = new LinkedList<>();
        nodeList.offer(p);
        isVisited[p] = true;
        distance[p] = 0;
        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            for(var neighbor: adjList.get(curr)){
                if(isVisited[neighbor]) continue;
                nodeList.offer(neighbor);
                isVisited[neighbor] = true;
                distance[neighbor] = distance[curr] + 1;
            }
        }
    }
}
