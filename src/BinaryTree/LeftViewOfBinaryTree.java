package BinaryTree;
import java.util.*;

//https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfBinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,5));
        System.out.println(leftView(root));
    }

    private static ArrayList<Integer> leftView(Node<Integer> root) {
        ArrayList<Integer> lans = new ArrayList<>();
        dfs(root, 0, lans);
        return lans;
    }

    private static void dfs(Node<Integer> root, int level, ArrayList<Integer> lans){
        if(root == null) return;
        if(lans.size() == level){
            lans.add(root.val);
        }
        dfs(root.left, level+1, lans);
        dfs(root.right, level+1, lans);
    }
}
