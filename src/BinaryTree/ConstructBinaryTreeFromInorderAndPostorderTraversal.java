package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        System.out.println(buildTree(inorder, postorder).val);
    }

    private static Node<Integer> buildTree(int[] inorder, int[] postorder) {
        //very similar to construct a bt from inorder and preorder traversal
        //TC = O(n), SC = O(n)
        Map<Integer, Integer> mappingInorder = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            mappingInorder.put(inorder[i], i);
        }
        int n = inorder.length;
        return createBt(inorder, postorder, 0, n-1, 0, n-1, mappingInorder);
    }

    private static Node<Integer> createBt(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, Map<Integer, Integer> mappingInorder){
        if(inorderStart > inorderEnd) return null;
        if(inorderStart == inorderEnd) return new Node<Integer>(inorder[inorderStart]);
        Node<Integer> root = new Node<Integer>(postorder[postorderEnd]);
        int rootIdx = mappingInorder.get(postorder[postorderEnd]);
        //for each subtree get the inorder start and end and also the postorder start and end
        root.left = createBt(inorder, postorder, inorderStart, rootIdx-1, postorderStart, postorderStart + rootIdx - 1 - inorderStart, mappingInorder);
        root.right = createBt(inorder, postorder, rootIdx+1, inorderEnd, postorderStart + rootIdx - inorderStart, postorderEnd-1, mappingInorder);;
        return root;
    }
}
