package BinaryTree;
import java.util.Arrays;

//https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,3,3,4,null,5,4,null,5));
        System.out.println(isSymmetric(root));
    }
    private static boolean isSymmetric(Node<Integer> root) {
        return root == null || dfs(root.left, root.right);
//        if(root == null) return true;
//        return dfs(root.left, root.right);
    }

    private static boolean dfs(Node<Integer> root1, Node<Integer> root2){
//        if(root1 == null && root2 == null) return true;
//        if(root1 == null || root2 == null) return false;
        if(root1 == null || root2 == null) return root1 == root2;
        return root1.val == root2.val && dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }
}
