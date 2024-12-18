package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/same-tree/description/
public class SameTree {
    public static void main(String[] args) {
        Node<Integer> root1 = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3));
        Node<Integer> root2 = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3));
        System.out.println(isSameTree(root1, root2));
    }

    private static boolean isSameTree(Node<Integer> p, Node<Integer> q) {
        //both trees are null then identical
//        if(p == null && q == null) return true;

        //if one is null and the other not null then not identical
//        if(p == null || q == null) return false;

        if(p == null || q == null) return p == q;

        //the two trees are identical if the current nodes value are equal in both trees and it is also identical in the left subtree as well as the right subtree
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
