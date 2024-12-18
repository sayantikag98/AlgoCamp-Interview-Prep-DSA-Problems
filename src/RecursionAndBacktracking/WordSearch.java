package RecursionAndBacktracking;

//https://leetcode.com/problems/word-search/
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(exist(board, word));
        System.out.println(exist1(board, word));
    }

    private static boolean exist1(char[][] board, String word) {
        //for finding the starting point because it need not be the 0,0 cell
        int[] rowOffset = {0, 1, 0, -1}, colOffset = {1, 0, -1, 0};
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(helper1(board, word, 0, i, j, rowOffset, colOffset)) return true;
            }
        }
        return false;
    }


    private static boolean  helper1(char[][] board, String word, int ind, int r, int c, int[] rowOffset, int[] colOffset){
        //similar to rat in a maze
        if(ind == word.length()) return true;
        if(r == -1 || r == board.length || c == -1 || c == board[0].length || board[r][c] != word.charAt(ind)) return false;
        //************this boolean ans makes sure that the backtracking is fully completed, and you don't update the input array**********
        boolean ans = false;
        board[r][c] = ' ';
        for(int i = 0; i<rowOffset.length; i++){
            if(helper1(board, word, ind+1, r+rowOffset[i], c+colOffset[i], rowOffset, colOffset))
            {
                ans = true;
                break;
            }
        }
        board[r][c] = word.charAt(ind);
        return ans;

    }
    private static boolean exist(char[][] board, String word) {
        //**********for finding the starting point because it need not be the 0,0 cell, so check each cell to be the starting point***********
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(helper(board, word, 0, i, j)){
//                    System.out.println(sb);
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean  helper(char[][] board, String word, int ind, int r, int c){
        //similar to rat in a maze
        if(r == -1 || r == board.length || c == -1 || c == board[0].length || board[r][c] != word.charAt(ind)) return false;
        if(ind == word.length()-1 && board[r][c] == word.charAt(ind)){
            return true;
        }
        boolean ans = false;
        board[r][c] -= 58; //constraint board only contains lowercase and upper case, so ascii 65 to 122 => total = 122-65+1 = 58
        //move right
        if(helper(board, word, ind+1, r, c+1)){
            ans = true;
        }
        //move down
        if(!ans && helper(board, word, ind+1, r+1, c)){
            ans = true;
        }
        //move left
        if(!ans && helper(board, word, ind+1, r, c-1)){
            ans = true;
        }
        //move up
        if(!ans && helper(board, word, ind+1, r-1, c)){
            ans = true;
        }
        board[r][c] += 58;
        return ans;
    }
}
