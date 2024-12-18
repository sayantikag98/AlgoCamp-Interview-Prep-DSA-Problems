package SearchingAndSorting.Searching;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15},{2,4,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(arr, target));
    }

    private static boolean searchMatrix(int[][] arr, int target){
        return helper(arr, target, 0, arr.length-1, 0, arr[0].length-1);
    }

    private static boolean helper(int[][] arr, int target, int rowStart, int rowEnd, int colStart, int colEnd){
        if(rowStart < 0 || rowEnd >= arr.length || colStart < 0 || colEnd >= arr[0].length || rowStart > rowEnd || colStart > colEnd) return false;
        int midRow = rowStart + (rowEnd - rowStart)/2;
        int midCol = colStart + (colEnd - colStart)/2;
        int mid = arr[midRow][midCol];
        if(mid == target) return true;
        else if(mid < target){
            if(helper(arr, target, rowStart, midRow, midCol+1, colEnd)) return true;
            return helper(arr, target, midRow+1, rowEnd, colStart, colEnd);
        }
        else{
            //************************** MADE MISTAKE HERE *****************************
            if(helper(arr, target, midRow, rowEnd, colStart, midCol-1)) return true;
            return helper(arr, target, rowStart, midRow-1, colStart, colEnd);
        }
    }
}
