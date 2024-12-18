package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderIterativeTraversal {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        Node<Integer> root = bt.binaryTreeFromArray(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(levelOrder(root));
        System.out.println(levelOrder1(root));
    }

    private static List<List<Integer>> levelOrder1(Node<Integer> root) {
        List<List<Integer>> lans = new ArrayList<>();
        if(root == null) return lans;

        Queue<Node<Integer>> nodeList = new LinkedList<>();
        nodeList.offer(root);

        //nodes at the same level will have child nodes at the same level
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            List<Integer> ans = new ArrayList<>();
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                ans.add(curr.val);
                if(curr.left != null){
                    nodeList.offer(curr.left);
                }
                if(curr.right != null){
                    nodeList.offer(curr.right);
                }
            }
            lans.add(ans);
        }

        return lans;
    }

    private static List<List<Integer>> levelOrder(Node<Integer> root) {
        //TC = O(n), SC = O(n)
        //Every node in the same level will have the child nodes at the same level
        //so keep a marker null to mark the end of a level
        List<List<Integer>> lans = new ArrayList<>();
        if(root != null){
            Queue<Node<Integer>> nodeList = new LinkedList<>();
            nodeList.offer(root);
            nodeList.offer(null);
            List<Integer> ans = new ArrayList<>();
            while(!nodeList.isEmpty()){
                Node<Integer> curr = nodeList.poll();
                if(curr == null){
                    if(!nodeList.isEmpty()) nodeList.offer(null); //MADE MISTAKE => checking queue is empty is important otherwise infinite loop
                    lans.add(ans);
                    ans = new ArrayList<>();
                }
                else{
                    if(curr.left != null) nodeList.offer(curr.left);
                    if(curr.right != null) nodeList.offer(curr.right);
                    ans.add(curr.val);
                }
            }
        }
        return lans;
    }
}
