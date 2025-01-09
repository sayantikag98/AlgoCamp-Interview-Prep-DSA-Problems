package BinaryTree;
import java.util.Arrays;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(4,2,7,1,3));
        System.out.println(searchBSTRecursive(root, 5));
        System.out.println(searchBSTIterative(root, 5));
    }

    private static Node<Integer> searchBSTIterative(Node<Integer> root, int val) {
        Node<Integer> curr = root;
        while(curr != null){
            if(curr.val == val) break;
            if(curr.val < val) curr = curr.right;
            else curr = curr.left;
        }
        return curr;
    }
    
    private static Node<Integer> searchBSTRecursive(Node<Integer> root, int val) {
        //TC = O(log n), SC = O(log n)
        if(root == null || root.val == val) return root;
        if(root.val < val){
            return searchBSTRecursive(root.right, val);
        }
        else{
            return searchBSTRecursive(root.left, val);
        }
    }
}
