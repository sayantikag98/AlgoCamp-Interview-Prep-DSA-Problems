package BinaryTree;

//https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeInABST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(10);
        bst.addNode(3);
        bst.addNode(7);
        bst.addNode(17);
        BinarySearchTree.Node root = bst.addNode(2);
        bst.inorder();
        System.out.println();
        root = deleteNode(root, 3);
        bst.inorder(root);
    }

    private static BinarySearchTree.Node deleteNode(BinarySearchTree.Node root, int key) {
        //Avg Case: TC = O(log n), SC = O(log n)
        //Worst Case: TC = O(n), SC = O(n)
        if(root == null) return root;
        if(root.val < key){
            //node to be deleted will be at right subtree
            root.right = deleteNode(root.right, key);
            return root;
        }
        else if(root.val > key){
            //node to be deleted will be at left subtree
            root.left = deleteNode(root.left, key);
            return root;
        }
        else{
            //current root will be deleted
            //root.val == key
            if(root.left == null){
                return root.right;
            }
            else{
                //largest value smaller than root.val
                int justSmallerVal = findJustSmallerNode(root.left).val;
                //replace root.val with just smaller value
                root.val = justSmallerVal;
                //recursively delete the just smaller node in the root.left subtree
                root.left = deleteNode(root.left, justSmallerVal);
                return root;
            }
        }
    }
    private static BinarySearchTree.Node findJustSmallerNode(BinarySearchTree.Node root){
        BinarySearchTree.Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }
}
