package SearchingAndSorting.Searching;

//https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(searchMatrixMoreConciseImplementation(arr, target));
    }

    private static boolean searchMatrixMoreConciseImplementation(int[][] arr, int target){
        //TC = O(log nm), SC = O(1)
        int n = arr.length, m = arr[0].length, low = 0, high = n*m-1;
        while(low<=high){
            int mid = low + (high - low)/2, row = mid/m, col = mid%m;
            if(arr[row][col] == target) return true;
            else if(arr[row][col] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }

    private static boolean searchMatrix(int[][] arr, int target){
        int rowStart = 0, colStart = 0, rowEnd = arr.length-1, colEnd = arr[0].length-1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            int midRow = rowStart + (rowEnd - rowStart)/2;
            int midCol = colStart + (colEnd - colStart)/2;
            if(arr[midRow][midCol] == target) return true;
            else if(arr[midRow][midCol] < target){
                if(arr[midRow][colEnd] == target) return true;
                else if(arr[midRow][colEnd] < target){
                    rowStart = midRow+1;
                }
                else{
                    rowStart = midRow;
                    rowEnd = midRow;
                    colStart = midCol+1;
                    colEnd = colEnd-1;
                }
            }
            else{
                if(arr[midRow][colStart] == target) return true;
                else if(arr[midRow][colStart] < target){
                    rowStart = midRow;
                    rowEnd = midRow;
                    colStart = colStart+1;
                    colEnd = midCol-1;
                }
                else{
                    rowEnd = midRow-1;
                }
            }
        }
        return false;
    }

}
