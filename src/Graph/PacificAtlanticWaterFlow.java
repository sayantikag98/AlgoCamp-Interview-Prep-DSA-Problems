package Graph;
import java.util.*;

//https://leetcode.com/problems/pacific-atlantic-water-flow/
public class PacificAtlanticWaterFlow {
    private static record Pair(int first, int second){}

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }

    private static List<List<Integer>> pacificAtlantic(int[][] heights) {
        //TC = O(n*m), SC = O(n*m)
        int n = heights.length, m = heights[0].length;

        Queue<Pair> nodeList = new LinkedList<>();
        int[][] isVisited = new int[n][m];

        //unvisited - 0
        //visited by only pacific - 1
        //visited by only atlantic - 2
        //visited by both - 3

        //for answer get the isVisited having value 3
        List<List<Integer>> lans = new ArrayList<>();

        //MULTI SOURCE BFS

        //for tracking the water flown from pacific to cells inside (reverse flow logic => apply bfs/dfs on the water flowing from pacific or atlantic to matrix inside (V.Imp))
        //initial sources for pacific would be all top and left cells
        for(int i = 0; i<n; i++){
            nodeList.offer(new Pair(i, 0));
            isVisited[i][0] = 1;
        }
        for(int i = 1; i<m; i++){
            nodeList.offer(new Pair(0, i));
            isVisited[0][i] = 1;
        }

        dfs(heights, nodeList, n, m, isVisited, true, lans);


        //for tracking the water flown from atlantic to cells inside
        //initial sources for atlantic would be all right and bottom cells
        for(int i = 0; i<n; i++){
            nodeList.offer(new Pair(i, m-1));
            if(isVisited[i][m-1] == 0) isVisited[i][m-1] = 2;
            else if(isVisited[i][m-1] == 1) {
                isVisited[i][m-1] = 3;
                lans.add(List.of(i, m-1));
            }
        }


        for(int i = 0; i<m-1; i++){
            nodeList.offer(new Pair(n-1, i));
            if(isVisited[n-1][i] == 0) isVisited[n-1][i] = 2;
            else if(isVisited[n-1][i] == 1) {
                isVisited[n-1][i] = 3;
                lans.add(List.of(n-1, i));
            }
        }

        dfs(heights, nodeList, n, m, isVisited, false, lans);

        return lans;
    }

    private static void bfs(int[][] heights, Queue<Pair> nodeList, int n, int m, int[][] isVisited, boolean isPacific, List<List<Integer>> lans){
        int[][] pos = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] isVisitedValidVal = new int[2];
        if(!isPacific) isVisitedValidVal[1] = 1;
        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            int row = curr.first(), col = curr.second();
            for(int k = 0; k<4; k++){
                int newRow = row + pos[k][0], newCol = col + pos[k][1];
                if(isValid(heights, n, m, newRow, newCol, row, col) && (isVisited[newRow][newCol] == isVisitedValidVal[0] || isVisited[newRow][newCol] == isVisitedValidVal[1])){
                    nodeList.offer(new Pair(newRow, newCol));
                    if(isPacific){
                        isVisited[newRow][newCol] = 1;
                    }
                    else{
                        if(isVisited[newRow][newCol] == 0) isVisited[newRow][newCol] = 2;
                        else if(isVisited[newRow][newCol] == 1) {
                            isVisited[newRow][newCol] = 3;
                            lans.add(List.of(newRow, newCol));
                        }
                    }
                }
            }
        }
    }

    private static void dfs(int[][] heights, Queue<Pair> nodeList, int n, int m, int[][] isVisited, boolean isPacific, List<List<Integer>> lans){
        int[][] pos = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] isVisitedValidVal = new int[2];
        if(!isPacific) isVisitedValidVal[1] = 1;
        //multi sources iterate and compute dfs
        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            int row = curr.first();
            int col = curr.second();
            helper(heights, n, m, row, col, pos, isVisitedValidVal, isVisited, isPacific, lans);
        }
    }

    private static void helper(int[][] heights, int n, int m, int row, int col, int[][] pos, int[] isVisitedValidVal, int[][] isVisited, boolean isPacific, List<List<Integer>> lans){
        if(isPacific){
            isVisited[row][col] = 1;
        }
        else{
            if(isVisited[row][col] == 0){
                isVisited[row][col] = 2;
            }
            else if(isVisited[row][col] == 1){
                isVisited[row][col] = 3;
                lans.add(List.of(row, col));
            }
        }

        for(int k = 0; k<4; k++){
            int newRow = row + pos[k][0];
            int newCol = col + pos[k][1];
            if(isValid(heights, n, m, newRow, newCol, row, col) && (isVisited[newRow][newCol] == isVisitedValidVal[0] || isVisited[newRow][newCol] == isVisitedValidVal[1])){
                helper(heights, n, m, newRow, newCol, pos, isVisitedValidVal, isVisited, isPacific, lans);
            }
        }
    }


    private static boolean isValid(int[][]heights, int n, int m, int nrow, int ncol, int crow, int ccol){
        //crow and ccol are valid
        return nrow>=0 && nrow<n && ncol>=0 && ncol<m && heights[nrow][ncol] >= heights[crow][ccol];
    }
}
