package BinaryTree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(6);
        bst.addNode(2);
        BinarySearchTree.Node root = bst.addNode(10);
        System.out.println(lowestCommonAncestorRecursive(root, root.left, root.right).val);
        System.out.println(lowestCommonAncestorIterative(root, root.left, root.right).val);
    }

    private static BinarySearchTree.Node lowestCommonAncestorRecursive(BinarySearchTree.Node root, BinarySearchTree.Node p, BinarySearchTree.Node q) {
        if(root == null || p == root || q == root) return root;
        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)){
            return root;
        }
        if(p.val < root.val){
            return lowestCommonAncestorRecursive(root.left, p, q);
        }
        return lowestCommonAncestorRecursive(root.right, p, q);
    }

    private static BinarySearchTree.Node lowestCommonAncestorIterative(BinarySearchTree.Node root, BinarySearchTree.Node p, BinarySearchTree.Node q) {
        BinarySearchTree.Node curr = root;
        while(true){
            if(curr == null || p == curr || q == curr) return curr;
            if((p.val < curr.val && q.val > curr.val) || (p.val > curr.val && q.val < curr.val)){
                return curr;
            }
            if(p.val < curr.val){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }
}
