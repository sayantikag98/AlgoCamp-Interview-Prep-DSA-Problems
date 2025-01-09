package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private static int k;
    private static Map<Integer, Integer> mapping;

    public static void main(String[] args) {
        int[] preorder = {1,2,4,3,5,7,8,6};
        int[] inorder = {4,2,1,7,5,8,3,6};
        System.out.println(buildTree(preorder,inorder).val);
        System.out.println(buildTree1(preorder, inorder).val);
    }

    private static Node<Integer> buildTree1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mapping = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            mapping.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1, 0, preorder.length-1, mapping);
    }

    private static Node<Integer> helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd, Map<Integer, Integer> mapping){
        if(inStart > inEnd) return null;
        if(inStart == inEnd) return new Node<>(inorder[inStart]);
        Node<Integer> root = new Node<>(preorder[preStart]);
        int rootIdx = mapping.get(preorder[preStart]);
        root.left = helper(preorder, inorder, inStart, rootIdx-1, preStart+1, preStart+rootIdx-inStart,mapping);
        root.right = helper(preorder, inorder, rootIdx+1, inEnd, preStart+rootIdx-inStart+1, preEnd,mapping);
        return root;
    }

    private static Node<Integer> buildTree(int[] preorder, int[] inorder) {
        k = 0;
        mapping = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            mapping.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }

    private static Node<Integer> helper(int[] preorder, int[] inorder, int start, int end){
        if(start > end) {
            k--;
            return null;
        }
        if(start == end) return new Node<Integer>(inorder[start]);
        Node<Integer> root = new Node<Integer>(preorder[k]);
        int rootIdx = mapping.get(preorder[k]);
        k++;
        root.left = helper(preorder, inorder, start, rootIdx-1);
        k++;
        root.right = helper(preorder, inorder, rootIdx+1, end);
        return root;
    }
}
