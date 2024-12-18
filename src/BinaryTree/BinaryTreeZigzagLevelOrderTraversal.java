package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(zigzagLevelOrderUsingDeque(root));
        System.out.println(zigzagLevelOrderUsingQueue(root));
    }

    private static List<List<Integer>> zigzagLevelOrderUsingDeque(Node<Integer> root) {
        //TC = O(n), SC = O(n)
        List<List<Integer>> lans = new ArrayList<>();
        if(root == null) return lans;
        Deque<Node<Integer>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        boolean isReverse = true;
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            List<Integer> ans = new ArrayList<>();
            while(size-->0){
                if(isReverse){
                    //add nodes from right
                    //remove nodes from left
                    //first add left child and then add right child
                    Node<Integer> curr = nodeList.poll();
                    ans.add(curr.val);
                    if(curr.left != null){
                        nodeList.offer(curr.left);
                    }
                    if(curr.right != null){
                        nodeList.offer(curr.right);
                    }
                }
                else{
                    //add nodes from left
                    //remove nodes from right
                    //first add right child and then add left child
                    Node<Integer> curr = nodeList.pollLast();
                    ans.add(curr.val);
                    if(curr.right != null){
                        nodeList.offerFirst(curr.right);
                    }
                    if(curr.left != null){
                        nodeList.offerFirst(curr.left);
                    }
                }
            }
            isReverse = !isReverse;
            lans.add(ans);
        }
        return lans;
    }

    private static List<List<Integer>> zigzagLevelOrderUsingQueue(Node<Integer> root) {
        List<List<Integer>> lans = new ArrayList<>();
        if(root == null) return lans;
        Queue <Node<Integer>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        boolean isReverse = true;
        while(!nodeList.isEmpty()){
            int size = nodeList.size(), n = size;
            List<Integer> ans = new LinkedList<>();
            for(int i = 0; i<size; i++){
                ans.add(0);
            }
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                if(isReverse){
                    ans.set(n-size-1, curr.val);
                }
                else{
                    ans.set(size, curr.val);
                }
                if(curr.left != null){
                    nodeList.offer(curr.left);
                }
                if(curr.right != null){
                    nodeList.offer(curr.right);
                }
            }
            isReverse = !isReverse;
            lans.add(ans);
        }
        return lans;
    }
}
