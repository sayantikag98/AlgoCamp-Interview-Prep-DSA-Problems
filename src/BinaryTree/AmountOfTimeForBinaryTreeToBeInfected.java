package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
//similar to Leetcode 863. All Nodes Distance K in Binary Tree
public class AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,5,3,null,4,10,6,null,null,9,2));
        System.out.println(amountOfTime(root, 3));
    }
    private static int amountOfTime(Node<Integer> root, int start) {
        Map<Node<Integer>, Node<Integer>> mapping = new HashMap<>();
        Queue<Node<Integer>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        //startNode will store the node having val as start
        Node<Integer> startNode = null;
        if(root.val == start){
            startNode = root;
        }
        //for getting parent & also getting the startNode from this bfs
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                if(curr.val == start){
                    startNode = curr;
                }
                if(curr.left != null){
                    nodeList.offer(curr.left);
                    mapping.put(curr.left, curr);
                }
                if(curr.right != null){
                    nodeList.offer(curr.right);
                    mapping.put(curr.right, curr);
                }
            }
        }

        //to get min time from this bfs
        //visited set keeps track of visited node
        Set<Node<Integer>> visited = new HashSet<>();
        nodeList.offer(startNode);
        visited.add(startNode);
        int time = -1;
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            //at every time instant the curr node will infect the parent node, left and right node
            //if its present and already not visited
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                //parent
                if(mapping.containsKey(curr) && !visited.contains(mapping.get(curr))){
                    nodeList.offer(mapping.get(curr));
                    visited.add(mapping.get(curr));
                }
                //left
                if(curr.left != null && !visited.contains(curr.left)){
                    nodeList.offer(curr.left);
                    visited.add(curr.left);
                }
                //right
                if(curr.right != null && !visited.contains(curr.right)){
                    nodeList.offer(curr.right);
                    visited.add(curr.right);
                }
            }
            time++;
        }
        return time;
    }
}
