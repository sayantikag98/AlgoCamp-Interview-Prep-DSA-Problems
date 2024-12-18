package BinaryTree;
import java.util.*;

//https://www.naukri.com/code360/problems/count-leaf-nodes_893055
public class CountLeafNodes {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(5, 4, 1, null, null, 6, 10));
        System.out.println(noOfLeafNodes(root));
    }

    private static int noOfLeafNodes(Node<Integer> root) {
        //TC = O(total nodes), SC = O(height of tree)
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return noOfLeafNodes(root.left) + noOfLeafNodes(root.right);
    }
}
