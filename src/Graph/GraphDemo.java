package Graph;
import java.util.*;

class Graph{
    private final List<List<Integer>> adjList;
    private final boolean isZeroBasedIndex;
    Graph(int v, boolean isZeroBasedIndex){
        this.adjList = new ArrayList<>();
        this.isZeroBasedIndex = isZeroBasedIndex;
        int endLimit = v;
        if(!this.isZeroBasedIndex) endLimit++;
        for(int i = 0; i<endLimit; i++){
            this.adjList.add(new LinkedList<>());
        }
    }

    void addEdge(int v1, int v2, boolean isUndirected){
        this.adjList.get(v1).add(v2);
        if(isUndirected){
            this.adjList.get(v2).add(v1);
        }
    }

    void addEdge(int v1, int v2){
        this.addEdge(v1, v2, true);
    }

    void display(){
        int startIdx = this.isZeroBasedIndex ? 0 : 1;
        for(int i = startIdx; i < this.adjList.size(); i++){
            System.out.print("vertex "+i+" -> ");
            for(var ele: this.adjList.get(i)){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
public class GraphDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many vertices do you have?");
        int v = sc.nextInt();
        System.out.println("How many edges do you have?");
        int e = sc.nextInt();
        System.out.println("Is it a zero based index?");
        boolean isZeroBasedIndex = sc.nextBoolean();
        Graph g = new Graph(v, isZeroBasedIndex);
        System.out.println("Is it a undirected graph?");
        boolean isUndirected = sc.nextBoolean();
        System.out.println("Please give the two vertex of each edge");
        for(int i = 0; i<e; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            g.addEdge(a, b, isUndirected);
        }
        g.display();
    }
}

/*
//zero based index
7 8
0 1
1 2
2 3
3 0
1 4
4 5
4 6
5 6

//one based index
4 6
1 2
1 3
1 4
2 3
2 4
3 4
 */
