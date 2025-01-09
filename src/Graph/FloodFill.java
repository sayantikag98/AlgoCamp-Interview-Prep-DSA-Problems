package Graph;
import java.util.*;

//https://leetcode.com/problems/flood-fill/description/
public class FloodFill {
    private static record Pair(int first, int second){}

    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,0,0}};
        floodFill(image, 0,0, 0);
        for(var di: image){
            System.out.println(Arrays.toString(di));
        }
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;
        int[] rowPos = {0, 1, 0, -1}, colPos = {1, 0, -1, 0};
        int oriColor = image[sr][sc];
        bfs(image, n, m, sr, sc, color, oriColor, rowPos, colPos);
        return image;
    }

    private static void dfs(int[][] image, int n, int m, int row, int col, int color, int oriColor, int[] rowPos, int[] colPos){
        //TC = O(n*m), SC = O(n*m)
        image[row][col] = color;
        for(int i = 0; i<rowPos.length; i++){
            if(isValid(image, n, m, row+rowPos[i], col+colPos[i], color, oriColor)){
                dfs(image, n, m, row+rowPos[i], col+colPos[i], color, oriColor, rowPos, colPos);
            }
        }
    }

    private static void bfs(int[][] image, int n, int m, int sr, int sc, int color, int oriColor, int[] rowPos, int[] colPos){
        //TC = O(n*m), SC = O(n*m)
        Queue<Pair> nodeList = new LinkedList<>();
        nodeList.offer(new Pair(sr, sc));
        image[sr][sc] = color;
        while(!nodeList.isEmpty()){
            Pair curr = nodeList.poll();
            for(int i = 0; i<rowPos.length; i++){
                int newRow = curr.first() + rowPos[i], newCol = curr.second() + colPos[i];
                if(isValid(image, n, m, newRow, newCol, color, oriColor)){
                    nodeList.offer(new Pair(newRow, newCol));
                    image[newRow][newCol] = color;
                }
            }
        }
    }

    private static boolean isValid(int[][] image, int n, int m, int row, int col, int color, int oriColor){
        return row >= 0 && row < n && col >= 0 && col < m && image[row][col] == oriColor && color != oriColor;
    }
}
