package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderIterativeTraversal {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,null,null,9));
        System.out.println(postorderTraversalUsingTwoStacks(root));
        System.out.println(postorderTraversalUsingOneStack(root));
    }

    private static List<Integer> postorderTraversalUsingOneStack(Node<Integer> root) {
        //this is my code which differs from Striver's code but have checked it by submitting on multiple platforms(leetcode, gfg, code studio, hackerrank)
        //TC = O(n), SC = O(n)
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node<Integer>> st = new Stack<>();
        Node<Integer> curr = root, prev = null;
        while(!st.empty() || curr != null){
            //move as left as possible
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                //this "if" will check for when the left and right subtree are explored and the current node is added in the ans list
                if(st.peek().right == null || prev == st.peek().right){
                    //prev will keep track of the last added node in the ans list
                    //this will help when the right subtree is already explored, and now it's time to add in the current peek node in the stack
                    prev = st.pop();
                    ans.add(prev.val);
                }
                //this will move to the right subtree and then begin the whole process of post order traversal (left -> right -> curr root)
                else{
                    curr = st.peek().right;
                }
            }
        }
        return ans;
    }

    private static List<Integer> postorderTraversalUsingTwoStacks(Node<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node<Integer>> st1 = new Stack<>(), st2 = new Stack<>();
        st1.push(root);
        while(!st1.empty()){
            Node<Integer> curr = st1.pop();
            st2.push(curr);
            if(curr.left != null){
                st1.push(curr.left);
            }
            if(curr.right != null){
                st1.push(curr.right);
            }
        }
        while(!st2.empty()){
            ans.add(st2.pop().val);
        }
        return ans;
    }
}
