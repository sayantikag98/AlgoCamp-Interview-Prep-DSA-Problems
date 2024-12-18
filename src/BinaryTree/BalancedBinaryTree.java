package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,2,3,3,null,null,4,4));
        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(Node<Integer> root) {
        //TC = O(n), SC = O(n)
        return helper(root) != -1;
    }

    private static int helper(Node<Integer> root){
        //this method returns the height of the tree if balanced and -1 if unbalanced
        if(root == null) return 0;
        int leftHeight = helper(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = helper(root.right);
        if(rightHeight == -1) return -1;
        //balanced binary tree => Math.abs(height of left subtree - height of right subtree) is either 0 or 1
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
