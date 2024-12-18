package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/binary-tree-right-side-view/description/
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,null,null,null,5));
        System.out.println(rightSideViewUsingBFS(root));
        System.out.println(rightSideViewUsingDFS(root));
    }

    private static List<Integer> rightSideViewUsingDFS(Node<Integer> root) {
        List<Integer> lans = new ArrayList<>();
        dfs(root, 0, lans);
        return lans;
    }

    private static void dfs(Node<Integer> root, int level, List<Integer> ans){
        //reverse preorder => root right left
        if(root == null) return;
        if(ans.size() == level){
            ans.add(root.val);
        }
        dfs(root.right, level+1, ans);
        dfs(root.left, level+1, ans);
    }

    private static List<Integer> rightSideViewUsingBFS(Node<Integer> root) {
        //TC = O(n), SC = O(n)
        //rightmost node of level order traversal
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node<Integer>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                if(curr.left != null){
                    nodeList.offer(curr.left);
                }
                if(curr.right != null){
                    nodeList.offer(curr.right);
                }
                if(size == 0) ans.add(curr.val);
            }
        }
        return ans;
    }
}
