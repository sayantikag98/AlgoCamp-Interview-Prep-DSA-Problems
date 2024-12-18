package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderIterativeTraversal {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,null,null,9));
        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversal1(root));
    }

    private static List<Integer> inorderTraversal1(Node<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node<Integer>> st = new Stack<>();
        Node<Integer> curr = root;
        while(true){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                if(!st.empty()){
                    ans.add(st.peek().val);
                    curr = st.pop().right;
                }
                else break;
            }
        }
        return ans;
    }

    private static List<Integer> inorderTraversal(Node<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node<Integer>> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            while(st.peek().left != null){
                st.push(st.peek().left);
            }
            Node<Integer> curr = st.pop();
            ans.add(curr.val);
            if(curr.right != null){
                st.push(curr.right);
            }
            else{
                while(!st.empty() && st.peek().right == null){
                    ans.add(st.pop().val);
                }
                if(!st.empty()){
                    curr = st.pop();
                    ans.add(curr.val);
                    st.push(curr.right);
                }
            }
        }
        return ans;
    }
}
