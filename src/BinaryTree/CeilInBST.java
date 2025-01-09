package BinaryTree;
import java.util.*;

//https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
public class CeilInBST {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(10, 5, 11, 4, 7, null, null, null, null, null, 8));
        System.out.println(findCeilIterative(root, 5));
        System.out.println(findCeilRecursive(root, 5));
    }

    private static int findCeilIterative(Node<Integer> root, int key) {
        //TC = O(log n), SC = O(1)
        int ans = -1;
        Node<Integer> curr = root;
        while(curr != null){
            if(curr.val == key){
                ans = key;
                break;
            }
            else if(curr.val < key){
                curr = curr.right;
            }
            else{
                ans = curr.val;
                curr = curr.left;
            }
        }
        return ans;
    }

    private static int findCeilRecursive(Node<Integer> root, int key) {
        int[] ans = {-1};
        helper(root, key, ans);
        return ans[0];
    }

    private static void helper(Node<Integer> root, int key, int[] ans){
        //TC = O(log n), SC = O(log n)
        if(root == null) return;
        if(root.val == key){
            ans[0] = key;
            return;
        }
        if(root.val < key){
            helper(root.right, key, ans);
        }
        else{
            ans[0] = root.val;
            helper(root.left, key, ans);
        }
    }
}
