package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(3,5,1,6,2,0,8));
        System.out.println(lowestCommonAncestorUsingBruteForce(root, root.left, root.left.right).val);
        System.out.println(lowestCommonAncestorUsingOptimizedApproach(root, root.left, root.left.right).val);
    }

    private static Node<Integer> lowestCommonAncestorUsingOptimizedApproach(Node<Integer> root, Node<Integer> p, Node<Integer> q) {
        //if a node is one of my node p or q then return that node
        if(root == p || root == q || root == null) return root;
        Node<Integer> left = lowestCommonAncestorUsingOptimizedApproach(root.left, p, q);
        Node<Integer> right = lowestCommonAncestorUsingOptimizedApproach(root.right, p, q);
        //if the left subtree and right subtree both returns not null values then that means that the node p and q was found in the left subtree and right subtree then that node is my lca
        if(left != null && right != null) return root;

        //if one of the subtree returns null then return the node from which node p or q was found

        //if both subtree returns null then that means node p and q was not found in any of the subtree then return null
        if(left != null) return left;
        return right;
    }
    private static Node<Integer> lowestCommonAncestorUsingBruteForce(Node<Integer> root, Node<Integer> p, Node<Integer> q) {
        List<Node<Integer>> path1 = new ArrayList<>(), path2 = new ArrayList<>();
        isPathFound(root, p, path1);
        isPathFound(root, q, path2);

        Set<Node<Integer>> s = new HashSet<>(path1);
        int i = path2.size()-1;
        while(i>=0){
            if(s.contains(path2.get(i))) return path2.get(i);
            i--;
        }

        return null;
    }

    private static boolean isPathFound(Node<Integer> root, Node<Integer> n, List<Node<Integer>> lans){
        if(root == null) return false;
        lans.add(root);
        if(root == n) return true;
        if(isPathFound(root.left, n, lans) || isPathFound(root.right, n, lans)) return true;
        lans.removeLast();
        return false;
    }
}
