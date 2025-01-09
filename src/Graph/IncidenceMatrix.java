package Graph;
import java.util.*;

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(), e = sc.nextInt();
        int[][] incidenceMatrix = new int[v][e];

        /*
        The incidence matrix A of an undirected graph has a row for each vertex and a
        column for each edge of the graph. The element A[[i,j]] of A is 1 if the
        ith vertex is a vertex of the jth edge and 0 otherwise.

        The incidence matrix A of a directed graph has a row for each vertex
        and a column for each edge of the graph. The element A[[i,j] of A
        is − 1 if the ith vertex is an initial vertex of the jth edge, 1 if
        the ith vertex is a terminal vertex, and 0 otherwise.
         */


        //zero based indexing
        for(int i = 0; i<e; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            incidenceMatrix[a][i] = 1;
            incidenceMatrix[b][i] = 1;

            // for directed graph if the edge is from vertex a to vertex b then
            // incidenceMatrix[a][i] = -1;
            // incidenceMatrix[b][i] = 1;
        }

        for(var arr: incidenceMatrix){
            for(var ele: arr){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
