package Graph;
import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //1 based indexing
        int[][] A = new int[n+1][n+1];
        for(int i = 0; i<m; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            A[a][b] = 1;
            A[b][a] = 1;
        }

        for(var row: A){
            for(var ele: row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
