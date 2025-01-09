package Graph;
import java.util.*;

public class AdjacencyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        //n+1 because 1 based indexing
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=m; i++){
            adjList.add(new LinkedList<>());
        }

        for(int i = 0; i<m; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for(var lists: adjList){
            for(var ele: lists){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
