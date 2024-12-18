package RecursionAndBacktracking;
import java.util.*;

//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

public class GFGRatInAMaze {
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath1(mat));
        System.out.println(findPath(mat));
    }

    private static ArrayList<String> findPath1(int[][] mat) {
        // Your code here
        ArrayList<String> lans = new ArrayList<>();
        helper1(mat, mat.length, 0, 0, new StringBuilder(), lans, "RDLU", new int[]{0, 1, 0, -1}, new int[]{1, 0, -1, 0});
        return lans;

    }

    private static void helper1(int[][] mat, int n, int r, int c, StringBuilder sb, List<String> lans, String paths, int[] row, int[] col){
        if(!isValid(n, r, c, mat)) return;

        if(r == n-1 & c == n-1){
            lans.add(sb.toString());
            return;
        }

        for(int i = 0; i<4; i++){
            sb.append(paths.charAt(i));
            mat[r][c] = 0;
            helper1(mat, n, r+row[i], c+col[i], sb, lans, paths, row, col);
            mat[r][c] = 1;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> lans = new ArrayList<>();
        helper(mat, mat.length, 0, 0, new StringBuilder(), lans);
        return lans;

    }
    private static void helper(int[][] mat, int n, int r, int c, StringBuilder sb, List<String> lans){
        //MADE MISTAKE => once a cell is visited mark it with 0 and when backtrack turn it back to 1
        //you have mark a visited to avoid visiting that cell all over again
        if(!isValid(n, r, c, mat)) return;

        //MADE MISTAKE => you need to check the n-1, n-1 cell if it has 0 or not first then only if 1 insert it in lans
        if(r == n-1 & c == n-1){
            lans.add(sb.toString());
            return;
        }

        //go right
        sb.append('R');
        mat[r][c] = 0;
        helper(mat, n, r, c+1, sb, lans);
        sb.deleteCharAt(sb.length()-1);
        mat[r][c] = 1;

        //go down
        sb.append('D');
        mat[r][c] = 0;
        helper(mat, n, r+1, c, sb, lans);
        sb.deleteCharAt(sb.length()-1);
        mat[r][c] = 1;

        //go left
        sb.append('L');
        mat[r][c] = 0;
        helper(mat, n, r, c-1, sb, lans);
        sb.deleteCharAt(sb.length()-1);
        mat[r][c] = 1;

        //go up
        sb.append('U');
        mat[r][c] = 0;
        helper(mat, n, r-1, c, sb, lans);
        sb.deleteCharAt(sb.length()-1);
        mat[r][c] = 1;
    }

    private static boolean isValid(int n, int r, int c, int[][] mat){
        return !(r == n || r == -1 || c == n || c == -1 || mat[r][c] == 0);
    }
}
