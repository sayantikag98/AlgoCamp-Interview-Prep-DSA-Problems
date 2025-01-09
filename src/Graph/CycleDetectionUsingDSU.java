package Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleDetectionUsingDSU {
    public static void main(String[] args) {
        //n -> no of elements, m -> no of queries
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements");
        int n = sc.nextInt();
        System.out.println("Enter the no of queries");
        int m = sc.nextInt();
        List<Integer> parent = new ArrayList<>(), rank = new ArrayList<>();
        for(int i = 0; i<n; i++){
            parent.add(i);
            rank.add(0);
        }
        for(int i = 0; i<m; i++){
            System.out.println("Enter the first element");
            int a = sc.nextInt();
            System.out.println("Enter the second element");
            int b = sc.nextInt();
            System.out.println(union(parent, rank, a, b));
        }
        //Time complexity - cycle detection in undirected graph using dsu O(E * log*n)
        //union time complexity - O(log*n) and no of edges times union called so above time complexity
    }

    private static int find(List<Integer> parent, int x){
        if(parent.get(x) == x){
            return x;
        }
        int par = find(parent, parent.get(x));
        parent.set(x, par);
        return par;
    }

    private static boolean union(List<Integer> parent, List<Integer> rank, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        if(a == b) return true; //cycle detected a,b in same cluster
        if(rank.get(a) <= rank.get(b)){
            parent.set(a, b);
            rank.set(b, rank.get(b)+1);
        }
        else{
            parent.set(b, a);
            rank.set(a, rank.get(a)+1);
        }
        return false; //no cycle
    }

}
