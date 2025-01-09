package BinaryTree;

//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node root = insertIntoBSTIterative(null, 10);
        root = insertIntoBSTIterative(root, 20);
        root = insertIntoBSTIterative(root, 4);
        root = insertIntoBSTRecursive(root, 1);
        bst.inorder(root);
    }

    private static BinarySearchTree.Node insertIntoBSTIterative(BinarySearchTree.Node root, int val) {
        //TC = O(log n) => average case
        //TC = O(n) => worst case
        //SC = O(1)
        BinarySearchTree.Node newNode = new BinarySearchTree.Node(val);
        if(root == null) return newNode;
        BinarySearchTree.Node curr = root;
        while(curr != null){
            if(curr.val < val){
                if(curr.right == null) {
                    curr.right = newNode;
                    break;
                }
                curr = curr.right;
            }
            else{
                if(curr.left == null){
                    curr.left = newNode;
                    break;
                }
                curr = curr.left;
            }
        }
        return root;
    }

    private static BinarySearchTree.Node insertIntoBSTRecursive(BinarySearchTree.Node root, int val) {
        //TC = O(log n) => average case
        //TC = O(n) => worst case
        //SC = O(log n) => average case
        //SC = O(n) => worst case
        if(root == null) return new BinarySearchTree.Node(val);
        if(root.val < val){
            //add to the right subtree
            root.right = insertIntoBSTRecursive(root.right, val);
        }
        else{
            //add to the left subtree
            root.left = insertIntoBSTRecursive(root.left, val);
        }
        return root;
    }
}
