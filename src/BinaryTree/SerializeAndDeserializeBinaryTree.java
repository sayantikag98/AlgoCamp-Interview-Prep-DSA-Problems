package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        Node<Integer> root = bt.binaryTreeFromArray(Arrays.asList(1,2,3,null,null,4,5));
        root = deserialize(serialize(root));
        bt.inOrder(root);
    }

    // Encodes a tree to a single string.
    private static String serialize(Node<Integer> root) {
        if(root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Queue<Node<Integer>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        sb.append(root.val).append(" ");
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                if(curr.left != null){
                    nodeList.offer(curr.left);
                    sb.append(curr.left.val).append(" ");
                }
                else{
                    sb.append("# ");
                }
                if(curr.right != null){
                    nodeList.offer(curr.right);
                    sb.append(curr.right.val).append(" ");
                }
                else{
                    sb.append("# ");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    private static Node<Integer> deserialize(String data) {
        if(data.equals("#")) return null;
        String[] d = data.split(" ");
        int idx = 0;

        //MADE MISTAKE => store node in the queue and not the string
        Queue<Node<Integer>> nodeList = new LinkedList<>();
        Node<Integer> root = new Node<Integer>(Integer.parseInt(d[idx]));
        nodeList.offer(root);
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            while(size-->0){
                Node<Integer> curr = nodeList.poll();
                idx++;
                if(d[idx].equals("#")){
                    curr.left = null;
                }
                else{
                    Node<Integer> newNode = new Node<Integer>(Integer.parseInt(d[idx]));
                    curr.left = newNode;
                    nodeList.offer(newNode);
                }
                idx++;
                if(d[idx].equals("#")){
                    curr.right = null;
                }
                else{
                    Node<Integer> newNode = new Node<Integer>(Integer.parseInt(d[idx]));
                    curr.right = newNode;
                    nodeList.offer(newNode);
                }
            }
        }
        return root;
    }

}
