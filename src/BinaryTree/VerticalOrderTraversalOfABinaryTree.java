package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class VerticalOrderTraversalOfABinaryTree {
    private record Pair<F, S>(F first, S second) {
    }

    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(verticalTraversalUsingDFS(root));
        System.out.println(verticalTraversalUsingBFS(root));
    }

    private static List<List<Integer>> verticalTraversalUsingDFS(Node<Integer> root) {
        //TC = O(nlogn), SC = O(n)
        List<List<Integer>> lans = new ArrayList<>();
        if(root == null) return lans;

        Map<Integer, List<Pair<Integer, Integer>>> verticalOrderMapping = new TreeMap<>();

        helper(root, 0, 0, verticalOrderMapping);

        for(var list: verticalOrderMapping.values()){
            list.sort((a, b) -> {
                if(a.first() < b.first()) return -1;
                if(a.first() > b.first()) return 1;
                return Integer.compare(a.second(), b.second());
            });
            List<Integer> ans = new ArrayList<>();
            for(var ele: list){
                ans.add(ele.second());
            }
            lans.add(ans);
        }
        return lans;
    }

    private static void helper(Node<Integer> root, int currCol, int currRow, Map<Integer, List<Pair<Integer, Integer>>> verticalOrderMapping){
        if(root == null) return;
        Pair<Integer, Integer> pair = new Pair<>(currRow, root.val);
        if(verticalOrderMapping.containsKey(currCol)){
            verticalOrderMapping.get(currCol).add(pair);
        }
        else{
            List<Pair<Integer, Integer>> ans = new ArrayList<>();
            ans.add(pair);
            verticalOrderMapping.put(currCol, ans);
        }
        helper(root.left, currCol-1, currRow+1, verticalOrderMapping);
        helper(root.right, currCol+1, currRow+1, verticalOrderMapping);
    }


    private static List<List<Integer>> verticalTraversalUsingBFS(Node<Integer> root) {
        List<List<Integer>> lans = new ArrayList<>();
        if(root == null) return lans;

        Queue<Pair<Node<Integer>, Integer>> nodeList = new LinkedList<>();
        nodeList.offer(new Pair<>(root, 0));

        Map<Integer, List<Integer>> mapping = new TreeMap<>();

        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            Map<Integer, List<Integer>> map = new HashMap<>(); // will store all node value from the same level
            while(size-->0){
                Pair<Node<Integer>, Integer> currNodeInfo = nodeList.poll();
                Node<Integer> curr = currNodeInfo.first();
                int currCol = currNodeInfo.second();

                if(map.containsKey(currCol)){
                    List<Integer> l = map.get(currCol);
                    l.add(curr.val);
                    Collections.sort(l);
                }
                else{
                    List<Integer> l = new ArrayList<>();
                    l.add(curr.val);
                    map.put(currCol, l);
                }

                if(curr.left != null){
                    nodeList.offer(new Pair<>(curr.left, currCol-1));
                }

                if(curr.right != null){
                    nodeList.offer(new Pair<>(curr.right, currCol+1));
                }
            }

            for(var k : map.keySet()){
                List<Integer> ans = map.get(k);
                if(mapping.containsKey(k)){
                    mapping.get(k).addAll(ans);
                }
                else{
                    mapping.put(k, ans);
                }
            }
        }

        lans.addAll(mapping.values());
        return lans;
    }

}
