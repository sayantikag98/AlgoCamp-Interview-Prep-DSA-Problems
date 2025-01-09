package Graph;
import java.util.*;

//https://leetcode.com/problems/surrounded-regions/
// same approach used in this problem => https://leetcode.com/problems/number-of-enclaves/
public class SurroundedRegions {
    private static record Pair(int first, int second){}

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for(var row: board){
            for(var val: row){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    private static void solve(char[][] board) {
        //TC = O(n*m), SC = O(n*m)
        int n = board.length, m = board[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //start the bfs/dfs traversal from all the boundary cell with 'O', after all the traversal is done, all the cells which cannot be converted will be marked as visited and then convert the rest of the unvisited 'O's to 'X'
        for(int i = 0; i<n; i++){
            //leftmost column
            if(board[i][0] == 'O' && !isVisited[i][0]){
                bfs(board, n, m, i, 0, isVisited, pos);
            }
            if(board[i][m-1] == 'O' && !isVisited[i][m-1]){
                //rightmost column
                bfs(board, n, m, i, m-1, isVisited, pos);
            }
        }
        for(int i = 1; i<m-1; i++){
            if(board[0][i] == 'O' && !isVisited[0][i]){
                //topmost row
                bfs(board, n, m, 0, i, isVisited, pos);
            }
            if(board[n-1][i] == 'O' && !isVisited[n-1][i]){
                //bottommost row
                bfs(board, n, m, n-1, i, isVisited, pos);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'O' && !isVisited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void bfs(char[][] board, int n, int m, int row, int col, boolean[][] isVisited, int[][] pos){
        Queue<Pair> nodeList = new LinkedList<>();
        nodeList.offer(new Pair(row, col));
        isVisited[row][col] = true;

        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            row = curr.first(); col = curr.second();
            for(int k = 0; k<4; k++){
                int newRow = row+pos[k][0];
                int newCol = col+pos[k][1];
                if(newRow < 0 || newRow == n || newCol < 0 || newCol == m || board[newRow][newCol] == 'X' || isVisited[newRow][newCol]) continue;
                nodeList.offer(new Pair(newRow, newCol));
                isVisited[newRow][newCol] = true;
            }
        }
    }

    private static void dfs(char[][] board, int n, int m, int row, int col, boolean[][] isVisited, int[][] pos){
        isVisited[row][col] = true;
        for(int k = 0; k<4; k++){
            int newRow = row+pos[k][0];
            int newCol = col+pos[k][1];
            if(newRow < 0 || newRow == n || newCol < 0 || newCol == m || board[newRow][newCol] == 'X' || isVisited[newRow][newCol]) continue;
            dfs(board, n, m, newRow, newCol, isVisited, pos);
        }
    }
}
