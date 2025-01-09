package Graph;
import java.util.*;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinishUsingBFS(2,new int[][]{{1,0},{0,1}}));
        System.out.println(canFinishUsingDFS(2,new int[][]{{1,0},{0,1}}));
    }

    private static boolean canFinishUsingBFS(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        return topologicalSortBFS(getAdjList(numCourses, prerequisites, inDegree), inDegree, numCourses);
    }

    private static boolean topologicalSortBFS(List<List<Integer>> adjList, int[] inDegree, int v){
        //Kahn's Algorithm
        Queue<Integer> nodeList = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(inDegree[i] == 0) nodeList.offer(i);
        }
        int cnt = 0;
        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            cnt++;
            for(var neighbors: adjList.get(curr)){
                inDegree[neighbors]--;
                if(inDegree[neighbors] == 0){
                    nodeList.offer(neighbors);
                }
            }
        }
        return cnt == v;
    }

    private static List<List<Integer>> getAdjList(int v, int[][] edges, int[] inDegree){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adjList.add(new ArrayList<>());
        }
        for(var edge: edges){
            adjList.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        return adjList;
    }

    private static boolean canFinishUsingDFS(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses], path = new boolean[numCourses];
        List<List<Integer>> adjList = getAdjList(numCourses, prerequisites);
        for(int i = 0; i<numCourses; i++){
            if(isVisited[i]) continue;
            if(!dfs(adjList, i, isVisited, path)) return false;
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> adjList, int src, boolean[] isVisited, boolean[] path){
        isVisited[src] = path[src] = true;
        for(var neighbors: adjList.get(src)){
            if(isVisited[neighbors]){
                if(path[neighbors]) return false; // cycle present
                continue;
            }
            if(!dfs(adjList, neighbors, isVisited, path)) return false;
        }
        path[src] = false;
        return true;
    }

    private static List<List<Integer>> getAdjList(int n, int[][] preReq){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(var coursePreReq: preReq){
            adjList.get(coursePreReq[1]).add(coursePreReq[0]);
        }
        return adjList;
    }
}
