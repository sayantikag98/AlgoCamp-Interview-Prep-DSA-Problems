package Graph;
import java.util.*;

//https://leetcode.com/problems/rotting-oranges/
public class RottenOranges {
    /*
    isVisited is required here - check this test case: [[2,2],[1,1],[0,0],[2,0]]
    */
    private static record Pair(int first, int second){}
    private static record Pair1(int first, int second, int third){}

    public static void main(String[] args) {
        int[][] grid = {{2,2},{1,1},{0,0},{2,0}};
        System.out.println(orangesRottingAnotherImplementation(grid));
        grid = new int[][]{{2,2},{1,1},{0,0},{2,0}};
        System.out.println(orangesRotting(grid));
        grid = new int[][]{{2,2},{1,1},{0,0},{2,0}};
        System.out.println(orangesRottingAnotherImplementation1(grid));
    }

    private static int orangesRottingAnotherImplementation1(int[][] grid) {
        //TC = O(n*m), SC = O(n*m)
        int n = grid.length, m = grid[0].length;
        Queue<Pair1> nodeList = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    nodeList.offer(new Pair1(i, j, 0));
                }
                if(grid[i][j] == 1) cnt++;
            }
        }
        int time = 0;
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!nodeList.isEmpty()){
            Pair1 curr = nodeList.poll();
            int row = curr.first(), col = curr.second();
            time = curr.third();
            for(int k = 0; k<4; k++){
                int newRow = curr.first() + pos[k][0];
                int newCol = curr.second() + pos[k][1];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1){
                    cnt--;
                    grid[newRow][newCol] = 2;
                    nodeList.offer(new Pair1(newRow, newCol, curr.third()+1));
                }
            }
        }
        if(cnt > 0) return -1;
        return time;
    }

    private static int orangesRottingAnotherImplementation(int[][] grid){
        //TC = O(n*m), SC = O(n*m)
        int n = grid.length, m = grid[0].length;
        Queue<Pair> nodeList = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];
        int countFresh = 0;
        //to initially get all the neighbors of the grid where rotten oranges are there(grid with value 2)
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1) countFresh++;  //keep track of fresh oranges if atlast return there is still fresh orange present we can return -1 using this
                if(grid[i][j] == 2){
                    // addingNeighbors(grid, n, m, i, j, nodeList, isVisited);
                    nodeList.offer(new Pair(i, j));
                }
            }
        }

        //put this marker only when queue is not empty
        if(!nodeList.isEmpty()){
            nodeList.offer(new Pair(-1, -1));
        }

        int time = -1; //initially time is kept -1 because initially the queue contains all cells with rotten oranges so time should increment from the next level
        //for each neighbors run bfs distance wise
        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            int row = curr.first();
            int col = curr.second();
            //marker check for next level in bfs
            if(row == -1){
                time++;
                //MADE MISTAKE => put this marker only when queue is not empty
                if(!nodeList.isEmpty()){
                    nodeList.offer(new Pair(-1, -1));
                }
            }
            else{
                if(grid[row][col] == 1) countFresh--;
                grid[row][col] = 2;
                addingNeighbors(grid, n, m, row, col, nodeList, isVisited);
            }
        }

        //if there is any 1 left which is not rotten return -1
        if(countFresh>0) return -1;

        return time == -1 ? 0 : time;
    }

    private static int orangesRotting(int[][] grid){
        //bfs should be applied here to get the minimum time to rot all fresh oranges if possible
        //MULTI SOURCE BFS
        int n = grid.length, m = grid[0].length;
        Queue<Pair> nodeList = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    // FOR MULTI SOURCE BFS
                    //we initially get all the cells with rotten oranges (value 2)
                    nodeList.offer(new Pair(i, j));
                }
            }
        }
        int time = -1;
        //for each neighbors run bfs distance wise
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            time++;
            while(size-->0){
                Pair curr = nodeList.poll();
                int row = curr.first();
                int col = curr.second();
                grid[row][col] = 2;
                addingNeighbors(grid, n, m, row, col, nodeList, isVisited);
            }
        }

        //if there is any 1 left which is not rotten return -1
        for(var row: grid){
            for(var ele: row){
                if(ele == 1) return -1;
            }
        }

        return time == -1 ? 0 : time;
    }

    private static void addingNeighbors(int[][] grid, int n, int m, int row, int col, Queue<Pair> nodeList, boolean[][] isVisited){
        int[] rowPos = {0, 1, 0, -1}, colPos = {1, 0, -1, 0};
        for(int k = 0; k<4; k++){
            int newRow = row + rowPos[k];
            int newCol = col + colPos[k];
            if(isValid(grid, n, m, newRow, newCol) && !isVisited[newRow][newCol]){
                nodeList.offer(new Pair(newRow, newCol));
                isVisited[newRow][newCol] = true;
            }
        }
    }

    private static boolean isValid(int[][] grid, int n, int m, int row, int col){
        return row>=0 && row<n && col>=0 && col<m && grid[row][col] == 1;
    }
}
