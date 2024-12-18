package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class BinaryTreePreorderIterativeTraversal {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,null,null,9));
        System.out.println(preorderTraversal(root));
    }
    private static List<Integer> preorderTraversal(Node<Integer> root) {
        //store first right child node and then left child node in stack
        //TC = O(n), SC = O(height of tree)
        List<Integer> lans = new ArrayList<>();
        if(root != null){
            Stack<Node<Integer>> st = new Stack<>();
            st.push(root);
            while(!st.empty()){
                Node<Integer> curr = st.pop();
                if(curr.right != null){
                    st.push(curr.right);
                }
                if(curr.left != null){
                    st.push(curr.left);
                }
                lans.add(curr.val);
            }
        }
        return lans;
    }
}
