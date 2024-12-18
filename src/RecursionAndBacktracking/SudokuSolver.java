package RecursionAndBacktracking;

//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        for(char[] chArr: board){
            for(char ch: chArr){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    private static void solveSudoku(char[][] board) {
        //TC = O(n^(n^2)) because if there are no constraints in the worst case, there would be n^2 (81) cells  ad each cell have n (9) choices
        //SC = O(n^2) for recursive stack space
        helper(board, 0, 0);
    }

    //return type should be boolean (vvv.imp) ONCE A SOLUTION IS FOUND RETURN TRUE AND DON'T BACKTRACK FURTHER => MADE MISTAKE HERE
    private static boolean helper(char[][] board, int i, int j){
        if(j == 9){
            //come out of 9 X 9 grid
            //will get a valid solution here
            return true;
        }
        if(i == 9){
            //move to the start of the next column
            return helper(board, 0, j+1);
        }
        else{
            if(board[i][j] != '.'){
                //move to the next row of the same column
                return helper(board, i+1, j);
            }
            else{
                //every cell coordinate can have a value from 1 to 10 so for loop used
                for(int val = 1; val<10; val++){
                    if(isValid(board, i, j, val)){
                        //(char)(val+'0') is imp => MADE MISTAKE
                        /*
                        When you want to store the character '1' in a cell, you need to assign it a value of 49 (the ASCII value of '1'), not 1 (the integer value)
                        If you use (char) val, you're directly casting the integer value to a character based on its ASCII value which is wrong.
                        (char) 1 would give you a non-printable ASCII control character with code 1, not the character '1'
                        (char) (1 + '0') = (char) (1 + 48) = (char) 49 = '1'
                         */
                        board[i][j] = (char)(val+'0');
                        //once a solution is found no need to backtrack further return true (VVV. IMP) => MADE MISTAKE
                        boolean isFound = helper(board, i+1, j);
                        if(isFound) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
    }



    private static boolean isValid(char[][] board, int row, int col, int val){
        char ch = (char)(val+'0');
        //check for row and column
        for(int i = 0; i<9; i++){
            if(board[row][i] == ch || board[i][col] == ch) return false;
        }
        //check for 3 X 3 grid

        //row and col are transformed to the start of that 3 X 3 grid
        row -= row%3;
        col -= col%3;

        //once transformed check for all the 9 cells in that 3 X 3 grid
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(board[row+i][col+j] == ch) return false;
            }
        }
        return true;
    }
}
