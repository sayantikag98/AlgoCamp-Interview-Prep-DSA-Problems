package Graph;
import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrderUsingBFS(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
        System.out.println(Arrays.toString(findOrderUsingDFS(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }

    private static int[] findOrderUsingBFS(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses], ans = new int[numCourses];
        boolean isEveryCourseFinished = topologicalSortBFS(getAdjList(numCourses, prerequisites, inDegree), inDegree, numCourses, ans);
        if(isEveryCourseFinished) return ans;
        return new int[]{};
    }

    private static boolean topologicalSortBFS(List<List<Integer>> adjList, int[] inDegree, int v, int[] ans){
        //Kahn's Algorithm = TC = O(V+E), SC = O(V+E)
        Queue<Integer> nodeList = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(inDegree[i] == 0) nodeList.offer(i);
        }
        int cnt = 0;
        while(!nodeList.isEmpty()){
            int curr = nodeList.poll();
            ans[cnt] = curr;
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

    private static int[] findOrderUsingDFS(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses], path = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> adjList = getAdjList(numCourses, prerequisites);
        for(int i = 0; i<numCourses; i++){
            if(isVisited[i]) continue;
            if(!dfs(adjList, i, isVisited, path, st)) return new int[]{};
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!st.empty()){
            ans[idx++] = st.pop();
        }
        return ans;
    }

    private static boolean dfs(List<List<Integer>> adjList, int src, boolean[] isVisited, boolean[] path, Stack<Integer> st){
        isVisited[src] = true;
        path[src] = true;
        for(var neighbors: adjList.get(src)){
            if(isVisited[neighbors]){
                if(path[neighbors]) return false;
                continue;
            }
            if(!dfs(adjList, neighbors, isVisited, path, st)) return false;
        }
        st.add(src);
        path[src] = false; //MAKING MISTAKE HERE ALWAYS MISSING THIS BACKTRACKING STEP
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
