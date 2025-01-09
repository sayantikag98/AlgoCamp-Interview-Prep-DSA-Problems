package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/count-complete-tree-nodes/
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,5,6));
        System.out.println(countNodes(root));
        System.out.println(countNodesOptimized(root));
    }

    private static int countNodesOptimized(Node<Integer> root) {
        //for every node I take the left height and the right height and if
        // they are equal then compute the total nodes from ((2^height)-1)
        // otherwise get the total nodes from 1 + total nodes of left subtree + total nodes of right subtree

        //TC = total recursive calls * time in each call
        //total recursive calls can be at max = log n i.e. height of the tree (if the left subtree is computed by recursive calls then right subtree might be repeatedly computed by formula)
        //time in each call is to get the left and the right height = log n
        //TC = O((log n)^2)
        //SC = O(log n)
        if(root == null) return 0;

        // to get the left and right height by computing the total nodes at the left boundary and the right boundary
        Node<Integer> currL = root, currR = root;
        int leftNodes = 0, rightNodes = 0;
        while(currL != null || currR != null){
            if(currL != null){
                leftNodes++;
                currL = currL.left;
            }
            if(currR != null){
                rightNodes++;
                currR = currR.right;
            }
        }
        if(leftNodes == rightNodes) return (1<<leftNodes) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int countNodes(Node<Integer> root) {
        if(root == null) return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return 1+leftCount+rightCount;
    }
}
