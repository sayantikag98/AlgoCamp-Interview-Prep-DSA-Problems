package Graph;
import java.util.*;

public class KahnAlgorithmImplementation {
    public static void main(String[] args) {
        int v = 8;
        boolean isZeroBased = true, isDirected = true;
        int[][] edges = {{0,2},{1,2},{1,3},{2,3},{2,4},{2,5},{6,2},{3,5},{4,6},{5,6},{6,7}};

        System.out.println(topologicalSortingUsingBFSOrKahnAlgorithm(makeGraph(v, edges, isZeroBased, isDirected)));
    }

    private static List<Integer> topologicalSortingUsingBFSOrKahnAlgorithm(List<List<Integer>> adjList){
        int[] inDegree = new int[adjList.size()];
        for(var neighbors: adjList){
            for(var nodes: neighbors){
                inDegree[nodes]++;
            }
        }
        Queue<Integer> nodeList = new LinkedList<>();
        List<Integer> traversal = new ArrayList<>();
        for(int i = 0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                nodeList.offer(i);
            }
        }
        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            traversal.add(curr);
            for(var neighbors: adjList.get(curr)){
                inDegree[neighbors]--;
                if(inDegree[neighbors] == 0){
                    nodeList.offer(neighbors);
                }
            }
        }
        return traversal;
    }

    private static List<List<Integer>> makeGraph(int v, int[][] edges, boolean isZeroBased, boolean isDirected){
        List<List<Integer>> adjList = new ArrayList<>();
        int n = isZeroBased ? v : v+1;
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(var vertices: edges){
            adjList.get(vertices[0]).add(vertices[1]);
            if(!isDirected){
                adjList.get(vertices[1]).add(vertices[0]);
            }
        }
        return adjList;
    }
}
