package Graph;
import java.util.*;

//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
public class NumberOfDistinctIslands {
    private static record Pair(int first, int second){}

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        System.out.println(countDistinctIslands(grid));
    }

    private static int countDistinctIslands(int[][] grid) {
        //TC = O(n*m), SC = O(n*m)
        int n = grid.length, m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //A Set<StringBuilder> considers each StringBuilder object unique based on its reference.
        //To ensure value-based uniqueness, use a Set<String> and store the String representations of StringBuilder.
        Set<String> shapeList = new HashSet<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && !isVisited[i][j]){
                    StringBuilder sb = new StringBuilder();
                    bfs(grid, n, m, i, j, isVisited, direction, -1, -1, sb);
                    shapeList.add(sb.toString());
                }
            }
        }
        return shapeList.size();
    }


    private static void dfs(int[][] grid, int n, int m, int row, int col, boolean[][] isVisited, int[][] direction, int baseRow, int baseCol, StringBuilder sb){
        isVisited[row][col] = true;
        if(baseRow == -1){
            baseRow = row;
            baseCol = col;
        }
        //store the string representation of all coordinates traversed minus the base coordinate
        sb.append(row - baseRow).append(" ").append(col - baseCol).append(" ");
        for(int k = 0; k<4; k++){
            int newRow = row + direction[k][0];
            int newCol = col + direction[k][1];
            if(newRow < 0 || newRow == n || newCol < 0 || newCol == m || grid[newRow][newCol] == 0 || isVisited[newRow][newCol]) continue;
            dfs(grid, n, m, newRow, newCol, isVisited, direction, baseRow, baseCol, sb);
        }
    }

    private static void bfs(int[][] grid, int n, int m, int row, int col, boolean[][] isVisited, int[][] direction, int baseRow, int baseCol, StringBuilder sb){
        Queue<Pair> nodeList = new LinkedList<>();
        nodeList.offer(new Pair(row, col));
        isVisited[row][col] = true;
        baseRow = row;
        baseCol = col;
        sb.append(0).append(" ").append(0).append(" ");

        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            row = curr.first();
            col = curr.second();

            for(int k = 0; k<4; k++){
                int newRow = row + direction[k][0];
                int newCol = col + direction[k][1];
                if(newRow < 0 || newRow == n || newCol < 0 || newCol == m || grid[newRow][newCol] == 0 || isVisited[newRow][newCol]) continue;
                nodeList.offer(new Pair(newRow, newCol));
                isVisited[newRow][newCol] = true;
                //store the string representation of all coordinates traversed minus the base coordinate
                sb.append(newRow - baseRow).append(" ").append(newCol - baseCol).append(" ");
            }
        }
    }
}
