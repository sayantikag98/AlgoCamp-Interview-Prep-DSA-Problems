package BinaryTree;
import java.util.*;

//https://www.naukri.com/code360/problems/boundary-traversal_790725
public class BoundaryTraversalOfBinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(100, 50, 150, 25, 75, 140, 200, null, 30, 70, 80, null, null, null, null, null, 35, null, null, null, null, null, null));
        System.out.println(traverseBoundary(root));
        System.out.println(traverseBoundary1(root));
    }

    private static List<Integer> traverseBoundary1(Node<Integer> root){
        //TC = O(n), SC = O(n)
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        ans.add(root.val);

        if(root.left == null && root.right == null) return ans;

        //left boundary traversal
        Node<Integer> curr = root.left;
        while(curr != null && (curr.left != null || curr.right != null)){
            ans.add(curr.val);
            if(curr.left == null) curr = curr.right;
            else curr = curr.left;
        }

        //leaf node traversal
        helper(root, ans);

        //right boundary traversal
        curr = root.right;
        Stack<Integer> st = new Stack<>();
        while(curr != null && (curr.left != null || curr.right != null)){
            st.push(curr.val);
            if(curr.right == null) curr = curr.left;
            else curr = curr.right;
        }
        while(!st.empty()){
            ans.add(st.pop());
        }

        return ans;
    }

    private static void helper(Node<Integer> root, List<Integer> ans){
        if(root == null) return;

        if(root.left == null && root.right == null){
            ans.add(root.val);
            return;
        }

        helper(root.left, ans);
        helper(root.right, ans);
    }

    private static List<Integer> traverseBoundary(Node<Integer> root){
        //TC = O(n), SC = O(n)

        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        if(root.left == null && root.right == null){
            ans.add(root.val);
            return ans;
        }

        boolean[] isLeft = {true, false};
        if(root.left == null){
            ans.add(root.val);
            isLeft[0] = false;
        }


        Node<Integer> curr = root.right, lastLeaf = null;
        while(curr != null){
            lastLeaf = curr;
            if(curr.right == null && curr.left != null){
                curr = curr.left;
            }
            else curr = curr.right;
        }

        helper(root, ans, isLeft, lastLeaf, root);

        return ans;
    }

    private static void helper(Node<Integer> root, List<Integer> ans, boolean[] isLeft, Node<Integer> lastLeaf, Node<Integer> rootCopy){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(root.val);
            isLeft[0] = false;
            if(root == lastLeaf) isLeft[1] = true;
            return;
        }
        if(isLeft[0]) ans.add(root.val);
        helper(root.left, ans, isLeft, lastLeaf, rootCopy);
        helper(root.right, ans, isLeft, lastLeaf, rootCopy);
        if(isLeft[1] && root != rootCopy) ans.add(root.val);
    }
}
