package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(3,5,1,6,2,0,8));
        System.out.println(distanceK(root, root.left, 1));
    }

    //TC = O(n), SC = O(n)
    private static List<Integer> distanceK(Node<Integer> root, Node<Integer> target, int k) {
        //contains mapping of the current node to its parent
        HashMap<Node<Integer>, Node<Integer>> mapping = new HashMap<>();

        //bfs for finding parent of every node required for the next traversal wherein for every node we traverse parent, left, right
        Queue<Node<Integer>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                if(curr.left != null){
                    nodeList.offer(curr.left);
                    mapping.put(curr.left, curr);
                }
                if(curr.right != null){
                    nodeList.offer(curr.right);
                    mapping.put(curr.right, curr);
                }
            }
        }

        //visited contains all nodes that are visited
        Set<Node<Integer>> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        int dist = 0;
        nodeList.offer(target);
        visited.add(target);
        //gradually increase the distance by 1
        while(dist != k){
            int size = nodeList.size();
            while(size-->0){
                //for every node check its parent, left and right (can be in any order)
                Node<Integer> curr = nodeList.poll();
                //parent
                if(mapping.containsKey(curr) && !visited.contains(mapping.get(curr))){
                    nodeList.offer(mapping.get(curr));
                    visited.add(mapping.get(curr));
                }
                //left
                if(curr.left != null && !visited.contains(curr.left)){
                    nodeList.offer(curr.left);
                    visited.add(curr.left);
                }
                //right
                if(curr.right != null && !visited.contains(curr.right)){
                    nodeList.offer(curr.right);
                    visited.add(curr.right);
                }
            }
            dist++;
        }
        while(!nodeList.isEmpty()){
            ans.add(nodeList.poll().val);
        }
        return ans;
    }
}
