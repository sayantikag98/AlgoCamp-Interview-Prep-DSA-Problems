package RecursionAndBacktracking;
import java.util.*;

//https://leetcode.com/problems/n-queens/
public class NQueens {
    public static void main(String[] args) {
//        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens1(4));
    }

    /*
    The given code is a solution for the N-Queens problem using backtracking. Let's analyze the time and space complexity.
Time Complexity Analysis

    Recursive Calls:
        The function helper1 tries to place a queen in every column of each row.
        For each column, it recursively checks the next column. Hence, there are n choices at the first step, n-1 choices at the second step, and so on.
        In the worst case, the number of recursive calls is proportional to n! (factorial of n), since it tries placing queens in different configurations.

    Validity Check:
        The isValid1 function checks if the current placement is valid.
        This involves iterating over the ans list (which has a size of j-1 at the jth recursive call).
        The time complexity for this check is O(n) in the worst case.

    Total Time Complexity:
        For each recursive call, we perform a check of O(n).
        The total number of recursive calls is n!, hence the time complexity is:
    O(n!×n)
    O(n!×n)

    This is because for each of the n! possible configurations, we validate it in O(n) time.

Space Complexity Analysis

    Space for Recursion Stack:
        The maximum depth of the recursion stack is n because we are placing n queens (one in each column).

    Space for Answer List:
        ans stores one valid configuration of queens, and its size is n.
        lans stores all the valid configurations. In the worst case, there can be O(n!) valid configurations, and each configuration is a list of n strings of size n.
        Thus, the total space used by lans is:
    O(n!×n2)
    O(n!×n2)

    StringBuilder Object:
        The StringBuilder object sb is used to create strings of length n. This is insignificant compared to the space required for storing all configurations.

    Overall Space Complexity:
    O(n+n!×n2)
    O(n+n!×n2)
        The O(n) is for the recursion stack and ans list.
        The O(n! \times n^2) is for storing all valid configurations.

Final Analysis

    Time Complexity: O(n!×n)O(n!×n)
    Space Complexity: O(n!×n2)O(n!×n2)

The exponential nature of both time and space complexity is due to the need to explore all possible configurations and store them.
     */


    private static List<List<String>> solveNQueens1(int n) {
        List<List<String>> lans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append('.');
        }
        helper1(n, 1, sb, new ArrayList<>(), lans);
        return lans;
    }

    private static void helper1(int n, int j, StringBuilder sb, List<Integer> ans, List<List<String>> lans){

        if(j == n+1){
            List<String> lstr = new ArrayList<>();
            for(int ele: ans){
                sb.setCharAt(ele-1, 'Q');
                lstr.add(sb.toString());
                sb.setCharAt(ele-1, '.');
            }
            lans.add(lstr);
            return;
        }

        //ans stores where queen is placed in that column ans[0] -> where queen is placed in the first column
        for(int i = 1; i<=n; i++){
            // i stands for row and j stands for col
            //current cell (i, j)
            if(!isValid1(ans, i, j)) continue;
            ans.add(i);
            helper1(n, j+1, sb, ans, lans);
            ans.removeLast();
        }

    }

    private static boolean isValid1(List<Integer> ans, int row, int col){
        //coordinates in 1 based indexing
        //queens already placed coordinate = (ans.get(k), k+1)
        //current coordinate to check = (row, col)
        //you only need to check row and bottom-left to top-right diagonal and top-left to bottom-right diagonal
        for(int k = 0; k<ans.size(); k++){
            int rowDiff = row - ans.get(k), colDiff = col - k - 1;
            if(rowDiff == 0 || Math.abs(rowDiff) == colDiff) return false;
        }
        return true;
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> lans = new ArrayList<>();
        helper(n, 1, new ArrayList<>(), lans);
        return lans;
    }

    private static void helper(int n, int j, List<Integer> ans, List<List<String>> lans){
        if(j == n+1){
            List<String> lstr = new ArrayList<>();
            for(int ele: ans){
                StringBuilder sb = new StringBuilder();
                for(int k = 1; k<=n; k++){
                    if(k == ele){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                lstr.add(sb.toString());
            }
            lans.add(lstr);
            return;
        }


        for(int i = 1; i<=n; i++){
            // i stands for row
            //current cell (i, j)
            boolean isPossible = true;
            for(int k = 0; k<ans.size(); k++){
                //placed queen coord = (ans.get(k), k+1)
                if(!isValid(ans.get(k), k+1, i, j)){
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible) continue;
            ans.add(i);
            helper(n, j+1, ans, lans);
            ans.removeLast();
        }

    }

    private static boolean isValid(int row1, int col1, int row2, int col2){
        int rowDiff = row2 - row1, colDiff = col2 - col1;
        return rowDiff != 0 && Math.abs(rowDiff) != colDiff;
    }
}
