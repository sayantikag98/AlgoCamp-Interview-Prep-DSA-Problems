package Graph;
import java.util.*;

//https://leetcode.com/problems/01-matrix/
public class ZeroOneMatrix {
    private static record Pair(int first, int second){}
    private static record Pair1(int first, int second, int third){}

    public static void main(String[] args) {
        int[][] mat = {{1,1,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{0,1,1,1,1},{1,1,1,1,1}};
        int[][] ans = updateMatrix(mat);
        for(var a: ans){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("___________");
        ans = new int[][]{{1,1,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{0,1,1,1,1},{1,1,1,1,1}};
        ans = updateMatrixUsingBruteForce(mat);
        for(var a: ans){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("___________");
        ans = new int[][]{{1,1,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{0,1,1,1,1},{1,1,1,1,1}};
        ans = updateMatrixAnotherImplementation(mat);
        for(var a: ans){
            System.out.println(Arrays.toString(a));
        }
    }

    private static int[][] updateMatrixAnotherImplementation(int[][] mat) {
        //TC = O(n*m), SC = O(n*m)
        int n = mat.length, m = mat[0].length;
        Queue<Pair1> nodeList = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    nodeList.offer(new Pair1(i, j, 0));
                    isVisited[i][j] = true;
                }
            }
        }
        int[][] pos ={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!nodeList.isEmpty()){
            Pair1 curr = nodeList.poll();
            int row = curr.first(), col = curr.second();
            mat[row][col] = curr.third();
            for(int k = 0; k<4; k++){
                int newRow = row + pos[k][0];
                int newCol = col + pos[k][1];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] == 1 && !isVisited[newRow][newCol]){
                    nodeList.offer(new Pair1(newRow, newCol, curr.third()+1));
                    isVisited[newRow][newCol] = true;
                }
            }
        }
        return mat;
    }

    private static int[][] updateMatrix(int[][] mat) {
        //TC = O(n*m), SC = O(n*m)
        int n = mat.length, m = mat[0].length;
        boolean[][] isVisited = new boolean[n][m];
        Queue<Pair> nodeList = new LinkedList<>();
        //multi source bfs to get the shortest path from any zero to one

        //start by putting all zero as multi source in the queue for bfs
        // V.Imp => initially put all zeroes as sources (reverse logic same as Pacific Atlantic Water Flow)
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    nodeList.offer(new Pair(i, j));
                    isVisited[i][j] = true;
                }
            }
        }
        if(!nodeList.isEmpty()){
            nodeList.offer(new Pair(-1, -1));
        }
        bfs(mat, n, m, isVisited, nodeList);
        return mat;
    }

    private static void bfs(int[][] mat, int n, int m, boolean[][] isVisited, Queue<Pair> nodeList){
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dist = 1;
        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            int currRow = curr.first();
            int currCol = curr.second();
            if(currRow == -1){
                //level wise increment distance
                dist++;
                if(!nodeList.isEmpty()){
                    nodeList.offer(new Pair(-1, -1));
                }
            }
            else{
                for(int k = 0; k<4; k++){
                    int newRow = currRow+pos[k][0];
                    int newCol = currCol+pos[k][1];
                    if(newRow<0 || newRow==n || newCol<0 || newCol==m || isVisited[newRow][newCol]) continue;
                    //whenever gathering neighbors update the distance in the matrix
                    mat[newRow][newCol] = dist;
                    nodeList.offer(new Pair(newRow, newCol));
                    isVisited[newRow][newCol] = true;
                }
            }
        }
    }

    private static int[][] updateMatrixUsingBruteForce(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        //brute force giving tle => applying individual bfs to every cell having one
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 1){
                    bfs(mat, n, m, i, j);
                }
            }
        }
        return mat;
    }

    private static void bfs(int[][] mat, int n, int m, int srcRow, int srcCol){
        Queue<Pair> nodeList = new LinkedList<>();
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] isVisited = new boolean[n][m];
        isVisited[srcRow][srcCol] = true;
        nodeList.offer(new Pair(srcRow, srcCol));
        nodeList.offer(new Pair(-1, -1));
        int dist = 1;
        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            int currRow = curr.first();
            int currCol = curr.second();
            if(currRow == -1){
                dist++;
                if(!nodeList.isEmpty()){
                    nodeList.offer(new Pair(-1, -1));
                }
            }
            else{
                for(int k = 0; k<4; k++){
                    int newRow = currRow+pos[k][0];
                    int newCol = currCol+pos[k][1];
                    if(newRow<0 || newRow==n || newCol<0 || newCol==m) continue;
                    if(mat[newRow][newCol] == 0){
                        mat[srcRow][srcCol] = dist;
                        return;
                    }
                    nodeList.offer(new Pair(newRow, newCol));
                    isVisited[newRow][newCol] = true;
                }
            }
        }
    }
}
