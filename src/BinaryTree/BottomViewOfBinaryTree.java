package BinaryTree;
import java.util.*;

//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BottomViewOfBinaryTree {
    private record Pair<F, S>(F first, S second){}

    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,5));
        System.out.println(bottomViewUsingDFS(root));
        System.out.println(bottomViewUsingBFS(root));
    }
    private static List<Integer> bottomViewUsingBFS(Node<Integer> root) {
        // Write your code here.
        //TC = O(n), SC = O(n)
        List<Integer> lans = new ArrayList<>();
        if(root == null) return lans;

        Queue<Pair<Node<Integer>, Integer>> nodeList = new LinkedList<>();

        Map<Integer, Integer> mapping = new TreeMap<>();

        nodeList.offer(new Pair<>(root, 0));

        while(!nodeList.isEmpty()){
            int size = nodeList.size();

            while(size-->0){
                Pair<Node<Integer>, Integer> pair = nodeList.poll();

                mapping.put(pair.second(), pair.first().val);

                if(pair.first().left != null){
                    nodeList.offer(new Pair<>(pair.first().left, pair.second()-1));
                }

                if(pair.first().right != null){
                    nodeList.offer(new Pair<>(pair.first().right, pair.second()+1));
                }
            }
        }

        lans.addAll(mapping.values());

        return lans;
    }
    private static ArrayList <Integer> bottomViewUsingDFS(Node<Integer> root)
    {
        // Code here
        ArrayList<Integer> lans = new ArrayList<>();
        if(root == null) return lans;

        Map<Integer, Pair<Integer, Integer>> mapping = new TreeMap<>();

        dfs(root, 0, 0, mapping);

        for(var v : mapping.values()){
            lans.add(v.first());
        }

        return lans;
    }

    private static void dfs(Node<Integer> root, int currCol, int currRow, Map<Integer, Pair<Integer, Integer>> mapping){
        if(root == null) return;
        if(mapping.containsKey(currCol)){
            Pair<Integer, Integer> pair = mapping.get(currCol);
            if(pair.second() <= currRow){
                mapping.put(currCol, new Pair<>(root.val, currRow));
            }
        }
        else{
            mapping.put(currCol, new Pair<>(root.val, currRow));
        }

        dfs(root.left, currCol-1, currRow+1, mapping);
        dfs(root.right, currCol+1, currRow+1, mapping);
    }
}
