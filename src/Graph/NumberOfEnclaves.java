package Graph;
import java.util.*;

//https://leetcode.com/problems/number-of-enclaves/
//same approach used in this problem https://leetcode.com/problems/surrounded-regions/
public class NumberOfEnclaves {
    private static record Pair(int first, int second){}
    private static int numEnclaves(int[][] grid) {
        //TC = O(n*m), SC = O(n*m)
        int n = grid.length, m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //start the bfs/dfs traversal from all the boundary cell with 1, after all the traversals are done all the cells which can be traversed will be marked as visited and then count the rest of the unvisited 1 and return.
        for(int i = 0; i<n; i++){
            //leftmost column
            if(grid[i][0] == 1 && !isVisited[i][0]){
                bfs(grid, n, m, i, 0, isVisited, pos);
            }
            if(grid[i][m-1] == 1 && !isVisited[i][m-1]){
                //rightmost column
                bfs(grid, n, m, i, m-1, isVisited, pos);
            }
        }
        for(int i = 1; i<m-1; i++){
            if(grid[0][i] == 1 && !isVisited[0][i]){
                //topmost row
                bfs(grid, n, m, 0, i, isVisited, pos);
            }
            if(grid[n-1][i] == 1 && !isVisited[n-1][i]){
                //bottommost row
                bfs(grid, n, m, n-1, i, isVisited, pos);
            }
        }
        int cnt = 0;
        for(int i = 1; i<n-1; i++){
            for(int j = 1; j<m-1; j++){
                if(grid[i][j] == 1 && !isVisited[i][j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void bfs(int[][] board, int n, int m, int row, int col, boolean[][] isVisited, int[][] pos){
        Queue<Pair> nodeList = new LinkedList<>();
        nodeList.offer(new Pair(row, col));
        isVisited[row][col] = true;

        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            row = curr.first(); col = curr.second();
            for(int k = 0; k<4; k++){
                int newRow = row+pos[k][0];
                int newCol = col+pos[k][1];
                if(newRow < 0 || newRow == n || newCol < 0 || newCol == m || board[newRow][newCol] == 0 || isVisited[newRow][newCol]) continue;
                nodeList.offer(new Pair(newRow, newCol));
                isVisited[newRow][newCol] = true;
            }
        }
    }

     private static void dfs(int[][] grid, int n, int m, int row, int col, boolean[][] isVisited, int[][] pos){
         isVisited[row][col] = true;
         for(int k = 0; k<4; k++){
             int newRow = row+pos[k][0];
             int newCol = col+pos[k][1];
             if(newRow < 0 || newRow == n || newCol < 0 || newCol == m || grid[newRow][newCol] == 0 || isVisited[newRow][newCol]) continue;
             dfs(grid, n, m, newRow, newCol, isVisited, pos);
         }
     }
}
