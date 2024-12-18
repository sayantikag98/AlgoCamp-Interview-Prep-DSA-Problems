package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(-1,-2,-3));
        System.out.println(maxPathSum(root));
    }

    private static int maxPathSum(Node<Integer> root) {
        //This code is similar to code of finding diameter of BT
        //TC = O(n), SC = O(n)
        int[] ans = {Integer.MIN_VALUE};
        helper(root, ans);
        return ans[0];
    }

    private static int helper(Node<Integer> root, int[] ans){
        if(root == null) return 0;
        //Never include a negative path sum because that will never lead to maximum path sum
        int leftSum = Math.max(0, helper(root.left, ans));
        int rightSum = Math.max(0, helper(root.right, ans));
        ans[0] = Math.max(ans[0], root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
