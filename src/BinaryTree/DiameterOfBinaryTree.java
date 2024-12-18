package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfBinaryTree {
    private static int diameter;

    private static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,5));
        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree1(root));
        System.out.println(diameterOfBinaryTree2(root));
    }

    private static int diameterOfBinaryTree2(Node<Integer> root) {
        //TC = O(n), SC = O(n)
        TreeInfo ans = helper1(root);
        return ans.diameter;
    }

    private static TreeInfo helper1(Node<Integer> root){
        if(root == null) return new TreeInfo(0, 0);
        TreeInfo leftSubtreeTreeInfo = helper1(root.left);
        TreeInfo rightSubtreeTreeInfo = helper1(root.right);
        int newHeight = 1 + Math.max(leftSubtreeTreeInfo.height, rightSubtreeTreeInfo.height);
        int maxDiameter = Math.max(leftSubtreeTreeInfo.diameter, rightSubtreeTreeInfo.diameter);
        maxDiameter = Math.max(maxDiameter, leftSubtreeTreeInfo.height + rightSubtreeTreeInfo.height);
        return new TreeInfo(newHeight, maxDiameter);
    }

    private static int diameterOfBinaryTree1(Node<Integer> root) {
        //TC = O(n), SC = O(n)
        final int[] ans = {0};
        helper(root, ans);
        return ans[0];

    }

    private static int helper(Node<Integer> root, int[] ans){
        if(root == null) return 0;
        int leftSubtreeHeight = helper(root.left, ans);
        int rightSubtreeHeight = helper(root.right, ans);
        ans[0] = Math.max(ans[0], leftSubtreeHeight+rightSubtreeHeight);
        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }

    private static int diameterOfBinaryTree(Node<Integer> root) {
        diameter = 0;
        helper(root);
        return diameter;

    }

    private static int helper(Node<Integer> root){
        if(root == null) return 0;
        int leftSubtreeHeight = helper(root.left);
        int rightSubtreeHeight = helper(root.right);
        diameter = Math.max(diameter, leftSubtreeHeight+rightSubtreeHeight);
        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }
}


