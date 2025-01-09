package BinaryTree;

public class RemoveAllLeafNodesFromBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(10);
        bst.addNode(20);
        bst.addNode(4);
        bst.addNode(1);
        BinarySearchTree.Node root = bst.addNode(50);
        bst.inorder(root);
        System.out.println();
        root = removeLeafNodes(root);
        bst.inorder(root);
    }

    private static BinarySearchTree.Node removeLeafNodes(BinarySearchTree.Node root){
        //TC = O(n) [both left and right subtree calls are being made], SC = O(h)
        if(root == null || root.left == null && root.right == null) return null;
        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        //continuously remove leaf node then put the case over here otherwise for only one level removal of leaf node put it at the top
        return root;
    }
}
