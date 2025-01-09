package Graph;
import java.util.*;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    private static record Pair(int first, int second){}

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        //TC = O(n*m), SC = O(n*m)
        int n = grid.length, m = grid[0].length;
        //isVisited is not required here can use the input array also
        boolean[][] isVisited = new boolean[n][m];
        int[] rowPos = {0, 1, 0, -1}, colPos = {1, 0, -1, 0};
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!isVisited[i][j] && grid[i][j] == '1'){
//                    bfs(grid, n, m, i, j, isVisited, rowPos, colPos);
                    dfs(grid, n, m, i, j, isVisited, rowPos, colPos);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(char[][] grid, int n, int m, int row, int col, boolean[][] isVisited, int[] rowPos, int[] colPos){
        Queue<Pair> nodeList = new LinkedList<>();
        nodeList.offer(new Pair(row, col));
        isVisited[row][col] = true;
        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            for(int i = 0; i<rowPos.length; i++){
                int newRow = curr.first()+rowPos[i], newCol = curr.second()+colPos[i];
                if(isValid(grid, n, m, newRow, newCol, isVisited)){
                    isVisited[newRow][newCol] = true;
                    nodeList.offer(new Pair(newRow, newCol));
                }
            }
        }
    }

    private static void dfs(char[][] grid, int n, int m, int row, int col, boolean[][] isVisited, int[] rowPos, int[] colPos){
        if(!isValid(grid, n, m, row, col, isVisited)) return;
        isVisited[row][col] = true;
        for(int i = 0; i<rowPos.length; i++){
            dfs(grid, n, m, row+rowPos[i], col+colPos[i], isVisited, rowPos, colPos);
        }
    }

    private static boolean isValid(char[][] grid, int n, int m, int row, int col, boolean[][] isVisited){
        return row >=0 && row < n && col >= 0 && col < m && !isVisited[row][col] && grid[row][col] != '0';
    }

}
