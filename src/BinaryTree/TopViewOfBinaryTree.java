package BinaryTree;
import java.util.*;


//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewOfBinaryTree {

    private record Pair<F, S>(F first, S second){}

    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,10,3,null,12,null,4,null,null,null,null,13,null,null));
        System.out.println(topViewUsingDFS(root));
        System.out.println(topViewUsingBFS(root));
    }

    private static List<Integer> topViewUsingBFS(Node<Integer> root) {
        // Write your code here.
        List<Integer> lans = new ArrayList<>();
        if(root == null) return lans;

        Queue<Pair<Node<Integer>, Integer>> nodeList = new LinkedList<>();

        Map<Integer, Integer> mapping = new TreeMap<>();

        nodeList.offer(new Pair<>(root, 0));

        while(!nodeList.isEmpty()){
            int size = nodeList.size();

            while(size-->0){
                Pair<Node<Integer>, Integer> pair = nodeList.poll();
                if(!mapping.containsKey(pair.second())){
                    mapping.put(pair.second(), pair.first().val);
                }
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

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    private static ArrayList<Integer> topViewUsingDFS(Node<Integer> root) {

        ArrayList<Integer> lans = new ArrayList<>();
        if(root == null) return lans;

        //mapping key -> column no
        //mapping value -> pair of row no and the node value

        Map<Integer, Pair<Integer, Integer>> mapping = new TreeMap<>();
        dfs(root, 0, 0, mapping);

        for(var v: mapping.values()){
            lans.add(v.second());
        }

        return lans;
    }

    private static void dfs(Node<Integer> root, int currCol, int currRow, Map<Integer, Pair<Integer, Integer>> mapping){
        if(root == null) return;

        if(mapping.containsKey(currCol)){
            Pair<Integer, Integer> p = mapping.get(currCol);
            if(p.first() > currRow){
                mapping.put(currCol, new Pair<>(currRow, root.val));
            }
        }
        else{
            mapping.put(currCol, new Pair<>(currRow, root.val));
        }

        dfs(root.left, currCol-1, currRow+1, mapping);
        dfs(root.right, currCol+1, currRow+1, mapping);
    }


}
