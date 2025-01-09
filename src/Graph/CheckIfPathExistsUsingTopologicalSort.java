package Graph;
import java.util.*;

public class CheckIfPathExistsUsingTopologicalSort {
    private static record Pair(int first, int second){}

    public static void main(String[] args) {
        int n = 4, m = 4;
        char[][] grid = {{'R', 'R', 'D', 'R'}, {'D','L','D','L'}, {'U','D','L','U'}, {'U','R','U','U'}};
        System.out.println(checkIfPathExistsUsingSlowAndFastPointer(grid, n, m));
        System.out.println(checkIfPathExistsRecursive(grid, n, m, 0, 0, 1));
        System.out.println(checkIfPathExistsIterative(grid, n, m));
    }

//    private static boolean checkIfPath(char[][] grid, int n, int m){
//        //This approach is an overkill, don't use this
//        int[][] inDegree = getInDegreeMatrix(grid, n, m);
//        Queue<Pair> nodeList = new LinkedList<>();
//        for(int i = 0; i<n; i++){
//            for(int j = 0; j<m; j++){
//                if(inDegree[i][j] == 0){
//                    nodeList.offer(new Pair(i, j));
//                }
//            }
//        }
//        while(!nodeList.isEmpty()){
//            Pair curr = nodeList.poll();
//            int currRow = curr.first();
//            int currCol = curr.second();
//            if(currRow == n-1 && currCol == m-1) return true;
//            if(grid[currRow][currCol] == 'R'){
//                if(isValidCell(n, m, currRow, currCol+1)){
//                    inDegree[currRow][currCol+1]--;
//                    if(inDegree[currRow][currCol+1] == 0){
//                        nodeList.offer(new Pair(currRow, currCol+1));
//                    }
//                }
//            }
//            else if(grid[currRow][currCol] == 'D'){
//                if(isValidCell(n, m, currRow+1, currCol)){
//                    inDegree[currRow+1][currCol]--;
//                    if(inDegree[currRow+1][currCol] == 0){
//                        nodeList.offer(new Pair(currRow+1, currCol));
//                    }
//                }
//            }
//            else if(grid[currRow][currCol] == 'L'){
//                if(isValidCell(n, m, currRow, currCol-1)){
//                    inDegree[currRow][currCol-1]--;
//                    if(inDegree[currRow][currCol-1] == 0){
//                        nodeList.offer(new Pair(currRow, currCol-1));
//                    }
//                }
//            }
//            else{
//                if(isValidCell(n, m, currRow-1, currCol)){
//                    inDegree[currRow-1][currCol]--;
//                    if(inDegree[currRow-1][currCol] == 0){
//                        nodeList.offer(new Pair(currRow-1, currCol));
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    private static int[][] getInDegreeMatrix(char[][] grid, int n, int m){
//        int[][] inDegree = new int[n][m];
//        int[][] pos = {{0, 1},{1, 0},{0, -1},{-1, 0}};
//        char[] directions = {'L', 'U', 'R', 'D'};
//        for(int i = 0; i<n; i++){
//            for(int j = 0; j<m; j++){
//                for(int k = 0; k<4; k++){
//                    if(isValidCell(n, m, i+pos[k][0], j+pos[k][1])  && grid[i+pos[k][0]][j+pos[k][1]] == directions[k]){
//                        inDegree[i][j]++;
//                    }
//                }
//            }
//        }
//        return inDegree;
//    }
//
    private static boolean isValidCell(int n, int m, int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
//

    private static boolean checkIfPathExistsUsingSlowAndFastPointer(char[][] grid, int n, int m){
        Pair slow = new Pair(0,0), fast = new Pair(0,0);
        while(true){
            if(!isValidCell(n, m, fast.first(), fast.second())){
                return (fast.first() == n-1 && fast.second() == m) || (fast.first() == n && fast.second() == m-1);
            }
            else{
                if(fast.first() == n-1 && fast.second() == m-1) return true;
            }
            slow = newPosition(grid, n, m, slow.first(), slow.second());
            fast = newPosition(grid, n, m, fast.first(), fast.second());
            if(isValidCell(n, m, fast.first(), fast.second())){
                fast = newPosition(grid, n, m, fast.first(), fast.second());
            }
            if(fast.equals(slow)) return false; //.equals important
        }
    }

    private static Pair newPosition(char[][] grid, int n, int m, int row, int col){
        if(grid[row][col] == 'R') {
            col++;
        }
        else if(grid[row][col] == 'D') {
            row++;
        }
        else if(grid[row][col] == 'L'){
            col--;
        }
        else{
            row--;
        }
        return new Pair(row, col);
    }


    private static boolean checkIfPathExistsIterative(char[][] grid, int n, int m){
        int row = 0, col = 0, step = 1;
        while(true){
            if(row < 0 || row == n || col < 0 || col == m || step > n*m) return false;
            if(row == n-1 && col == m-1) return true;
            if(grid[row][col] == 'R') {
                col++;
            }
            else if(grid[row][col] == 'D') {
                row++;
            }
            else if(grid[row][col] == 'L'){
                col--;
            }
            else{
                row--;
            }
            step++;
        }
    }

    private static boolean checkIfPathExistsRecursive(char[][] grid, int n, int m, int row, int col, int step){
        //for cycle detection => (step > n*m)
        if(row < 0 || row == n || col < 0 || col == m || step > n*m) return false;
        if(row == n-1 && col == m-1) return true;
        if(grid[row][col] == 'R')
            return checkIfPathExistsRecursive(grid, n, m, row, col+1, step+1);
        else if(grid[row][col] == 'D')
            return checkIfPathExistsRecursive(grid, n, m, row+1, col, step+1);
        else if(grid[row][col] == 'L')
            return checkIfPathExistsRecursive(grid, n, m, row, col-1, step+1);
        return checkIfPathExistsRecursive(grid, n, m, row-1, col, step+1);
    }
}
