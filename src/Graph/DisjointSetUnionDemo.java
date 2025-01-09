package Graph;
import java.util.*;

public class DisjointSetUnionDemo {

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
        DisjointSetUnion dsu = new DisjointSetUnion(n, true);
        for(int i = 0; i<m; i++){
            System.out.println("Do you want to run find or union query. Press 1 for find and 2 for union");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Enter the element");
                int x = sc.nextInt();
                System.out.println(find(parent, x));
                System.out.println(dsu.find(x));
            }
            else if(choice == 2){
                System.out.println("Enter the first element");
                int a = sc.nextInt();
                System.out.println("Enter the second element");
                int b = sc.nextInt();
                union(parent, rank, a, b);
                dsu.unionByRank(a, b);
            }
            else{
                System.out.println("Enter a valid choice");
            }
        }
    }

    private static int find(List<Integer> parent, int x){
        //TC = O(log* n) = O(alpha n) where alpha is the inverse ackermann function
        if(parent.get(x) == x){
            return x;
        }
        int p = find(parent, parent.get(x));
        parent.set(x, p);
        return p;
    }

    private static void union(List<Integer> parent, List<Integer> rank, int a, int b){
        //TC = O(log* n) = O(alpha n) where alpha is the inverse ackermann function
        a = find(parent, a);
        b = find(parent, b);
        if(a!=b){
            if(rank.get(a) < rank.get(b)){
                //smaller group attached with larger group
                parent.set(a, b);
            }
            else if(rank.get(a) > rank.get(b)){
                parent.set(b, a);
            }
            else{
                parent.set(a, b);
                rank.set(b, rank.get(b)+1);
            }
        }
    }
}

class DisjointSetUnion{
    private final int[] parent, rank, size;
    int cntCC;
    DisjointSetUnion(int nodes, boolean isZeroBased){
        this.cntCC = nodes;
        if(!isZeroBased) nodes++;
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.size = new int[nodes];
        for(int i = 0; i<nodes; i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    //union by rank with path compression
    int find(int x){
        int root = x;
        while(this.parent[root] != root){
            root = this.parent[root];
        }
        while(x != root){
            int temp = this.parent[x];
            this.parent[x] = root;
            x = temp;
        }
        return root;

        //recursive find
//        if(this.parent[x] == x) return x;
//        return this.parent[x] = find(this.parent[x]);
    }

    void unionByRank(int a, int b){
        int parentA = this.find(a);
        int parentB = this.find(b);
        //parentA == parentB is when they are the same components
        if(parentA != parentB){
            if(this.rank[parentA] < this.rank[parentB]){
                this.parent[parentA] = parentB;
            }
            else if(this.rank[parentA] > this.rank[parentB]){
                this.parent[parentB] = parentA;
            }
            else{
                this.parent[parentA] = parentB;
                this.rank[parentB]++;
            }
            this.cntCC--;
        }
    }

    void unionBySize(int a, int b){
        int parentA = this.find(a);
        int parentB = this.find(b);
        if(parentA != parentB){
            if(this.size[parentA] <= this.size[parentB]){
                this.parent[parentA] = parentB;
                this.size[parentB] += this.size[parentA];
            }
            else{
                this.parent[parentB] = parentA;
                this.size[parentA] += this.size[parentB];
            }
            this.cntCC--;
        }
    }

    int countConnectedComponents(){
        return this.cntCC;
    }
}
