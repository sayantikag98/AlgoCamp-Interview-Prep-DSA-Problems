package BinaryTree;

import java.util.*;
class Node <T>{
    T val;
    Node<T> left, right;

    Node(T val){
        this.val = val;
        this.left = this.right = null;
    }
}

class BinaryTree<T> {
    private Node<T> root;

    BinaryTree(){
        this.root = null;
    }


    void preOrder(Node<T> root){
        //TC = O(n) where n is total nodes, SC = O(height of tree) ~ O(n) because height of tree can be at max n
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(Node<T> root){
        //TC = O(n) where n is total nodes, SC = O(height of tree) ~ O(n) because height of tree can be at max n
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    void postOrder(Node<T> root){
        //TC = O(n) where n is total nodes, SC = O(height of tree) ~ O(n) because height of tree can be at max n
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    void levelOrder(Node<T> root){
        if(root == null) return;
        Queue<Node<T>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while(!nodeList.isEmpty()){
            Node<T> curr = nodeList.poll();
            if(curr.left != null) nodeList.offer(curr.left);
            if(curr.right != null) nodeList.offer(curr.right);
            System.out.print(curr.val+" ");
        }
    }

    Node<T> binaryTreeFromArray(List<T> arr){
        if(arr.isEmpty() || arr.getFirst() == null) return null;
        int n = arr.size();
        List<Node<T>> nodeList = new ArrayList<>(n);
        Node<T> root = new Node<>(arr.getFirst());
        nodeList.add(root);
        for(int i = 0; 2*i<n; i++){
            Node<T> curr = nodeList.get(i);
            if(curr != null){
                int leftIdx = 2*i+1, rightIdx = 2*i+2;
                if(leftIdx < n){
                    if(arr.get(leftIdx) != null){
                        curr.left = new Node<>(arr.get(leftIdx));
                    }
                    else{
                        curr.left = null;
                    }
                    nodeList.add(curr.left);
                }
                if(rightIdx < n){
                    if(arr.get(rightIdx) != null){
                        curr.right = new Node<>(arr.get(rightIdx));
                    }
                    else{
                        curr.right = null;
                    }
                    nodeList.add(curr.right);
                }
            }
            else{
                nodeList.add(null);
            }
        }
        return root;
    }
}

public class BinaryTreeDemo{
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.left.right.left = new Node<>(8);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
        root.right.right.left = new Node<>(9);
        root.right.right.right = new Node<>(10);

        bt.preOrder(root);
        System.out.println();
        bt.inOrder(root);
        System.out.println();
        bt.postOrder(root);
        System.out.println();
        bt.levelOrder(root);
        System.out.println();

        Node<Integer> root1 = bt.binaryTreeFromArray(Arrays.asList(1,2,3,4,5,6,7,null,null,8,null,null,null,9,10));
        bt.preOrder(root1);
        System.out.println();
        bt.inOrder(root1);
        System.out.println();
        bt.postOrder(root1);
        System.out.println();
        bt.levelOrder(root1);
        System.out.println();

        Node<Integer> root2 = bt.binaryTreeFromArray(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,null,null,9));
        bt.preOrder(root2);
        System.out.println();
        bt.inOrder(root2);
        System.out.println();
        bt.postOrder(root2);
        System.out.println();
        bt.levelOrder(root2);
        System.out.println();
    }
}
