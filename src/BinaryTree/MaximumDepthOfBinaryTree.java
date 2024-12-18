package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(maxDepthUsingDFS(root));
        System.out.println(maxDepthUsingBFS(root));
    }

    private static int maxDepthUsingDFS(Node<Integer> root) {
        //TC = O(n), SC=O(max depth of tree)
        if(root == null) return 0;
        int maxDepthLeft = maxDepthUsingDFS(root.left);
        int maxDepthRight = maxDepthUsingDFS(root.right);
        return 1 + Math.max(maxDepthLeft, maxDepthRight);
    }

    private static int maxDepthUsingBFS(Node<Integer> root){
        if(root == null) return 0;
        Queue<Node<Integer>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        int height = 0;
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            height++;
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                if(curr.left != null){
                    nodeList.offer(curr.left);
                }
                if(curr.right != null){
                    nodeList.offer(curr.right);
                }
            }
        }
        return height;
    }
}
