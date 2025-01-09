package BinaryTree;
import java.util.Arrays;

//https://leetcode.com/problems/delete-leaves-with-a-given-value/
public class DeleteLeavesWithAGivenValue {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        Node<Integer> root = bt.binaryTreeFromArray(Arrays.asList(1,2,null,2,null,2));
        bt.inOrder(removeLeafNodes(root, 2));
    }

    private static Node<Integer> removeLeafNodes(Node<Integer> root, int target) {
        //TC = O(n), SC = O(n)
        if(root == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.val == target && root.left == null && root.right == null) return null;
        return root;
    }
}
