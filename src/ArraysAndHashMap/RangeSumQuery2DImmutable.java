package ArraysAndHashMap;
//https://leetcode.com/problems/range-sum-query-2d-immutable/description/
public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        numMatrix(matrix);
        System.out.println(sumRegion(matrix, 2, 1, 4, 3));
    }
    private static void numMatrix(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                int sum = matrix[i][j];
                if(j>0) sum+=matrix[i][j-1];
                if(i>0) sum+=matrix[i-1][j];
                if(i>0 && j>0) sum-=matrix[i-1][j-1];
                if(matrix[i][j] != sum) matrix[i][j] = sum;
            }
        }
    }

    private static int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
        int sum = matrix[row2][col2];
        if(col1>0) sum-=matrix[row2][col1-1];
        if(row1>0) sum-=matrix[row1-1][col2];
        if(row1>0 && col1>0) sum+=matrix[row1-1][col1-1];
        return sum;
    }
}
