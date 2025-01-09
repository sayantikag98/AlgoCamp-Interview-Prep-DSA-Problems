package BinaryTree;
import java.util.*;

//https://www.naukri.com/code360/problems/childrensumproperty_790723
public class ChildrenSumProperty {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        Node<Integer> root = bt.binaryTreeFromArray(Arrays.asList(2,35,10,2,3,5,2));
        bt.levelOrder(root);
        System.out.println();
        changeTree(root);
        bt.levelOrder(root);
    }
    private static void changeTree(Node<Integer> root) {
        // Write your code here.
        if(root == null) return;

        //this makes sure that sum of the left child value + right child value of the current root node
        //is never less than the value of the parent node
        int leftVal = root.left == null ? 0 : root.left.val;
        int rightVal = root.right == null ? 0 : root.right.val;
        if(leftVal + rightVal < root.val){
            if(root.left != null){
                root.left.val += root.val - (leftVal + rightVal);
            }
            else if(root.right != null){
                root.right.val += root.val - rightVal;
            }
        }

        changeTree(root.left);
        changeTree(root.right);


        //MADE MISTAKE HERE IN CASE OF LEAF NODE
        //if leaf node return
        if(root.left == null && root.right == null) return;


        //update the current root value with the sum of left child and right child value
        leftVal = root.left == null ? 0 : root.left.val;
        rightVal = root.right == null ? 0 : root.right.val;
        root.val = leftVal + rightVal;
    }
}
