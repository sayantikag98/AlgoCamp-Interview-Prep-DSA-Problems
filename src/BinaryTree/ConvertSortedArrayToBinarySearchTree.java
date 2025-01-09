package BinaryTree;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {-10, -5, 5, 23, 50};
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node root = sortedArrayToBSTRecursive(nums);
        bst.inorder(root);
    }

    private static BinarySearchTree.Node sortedArrayToBSTRecursive(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private static BinarySearchTree.Node helper(int[] nums, int start, int end){
        //TC = O(n), SC = O(height of bst created) = O(log n) [height balanced means log n base 2]
        if(start > end) return null;
        int mid = start + (end - start)/2;
        BinarySearchTree.Node root = new BinarySearchTree.Node(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
