package BinaryTree;

//https://www.geeksforgeeks.org/problems/predecessor-and-successor/0
public class InorderPredecessorAndSuccessorForAGivenKeyInBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(8);
        bst.addNode(1);
        bst.addNode(9);
        bst.addNode(4);
        bst.addNode(3);
        BinarySearchTree.Node root = bst.addNode(10);
        BinarySearchTree.Node[] pre = {null}, suc = {null};
        findPreSucIterative(root, pre, suc, 1);
        if(pre[0] == null){
            System.out.println("Inorder predecessor: "+ null);
        }
        else{
            System.out.println("Inorder predecessor: "+ pre[0].val);
        }
        if(suc[0] == null){
            System.out.println("Inorder successor: "+ null);
        }
        else{
            System.out.println("Inorder successor: "+ suc[0].val);
        }
        pre[0] = suc[0] = null;
        findPreSucRecursive(root, pre, suc, 1);
        if(pre[0] == null){
            System.out.println("Inorder predecessor: "+ null);
        }
        else{
            System.out.println("Inorder predecessor: "+ pre[0].val);
        }
        if(suc[0] == null){
            System.out.println("Inorder successor: "+ null);
        }
        else{
            System.out.println("Inorder successor: "+ suc[0].val);
        }
    }

    private static void findPreSucIterative(BinarySearchTree.Node root, BinarySearchTree.Node [] pre, BinarySearchTree.Node [] suc, int key) {
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key

        //predecessor => greatest smaller value than key
        //successor => smallest greater value than key

        //brute force: find and store the inorder traversal and get its immediate previous value and immediate next value of key

        BinarySearchTree.Node curr = root;
        while(curr != null && curr.val != key){
            //while traversing the bst and searching for key and store max of smaller value than key as an intermediate value of predecessor
            // and similarly store min of greater value than key as an intermediate value of successor
            if(curr.val < key){
                pre[0] = curr;
                curr = curr.right;
            }
            else{
                suc[0] = curr;
                curr = curr.left;
            }
        }

        if(curr == null) return; //either tree is empty or key not found

        //curr -> key node

        if(curr.left != null){
            //if left child is present try to find out the rightmost node of the left subtree because it's just smaller than key
            BinarySearchTree.Node temp = curr.left;
            while(temp.right != null){
                temp = temp.right;
            }
            pre[0] = temp;
        }

        if(curr.right != null){
            //if right child is present try to find out the leftmost node of the right subtree because it's just greater than key
            BinarySearchTree.Node temp = curr.right;
            while(temp.left != null){
                temp = temp.left;
            }
            suc[0] = temp;
        }
    }

    private static void findPreSucRecursive(BinarySearchTree.Node root, BinarySearchTree.Node[] pre, BinarySearchTree.Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key

        //TC = O(h), SC = O(h)

        if(root == null) return;

        if(root.val < key){
            //may be a predecessor
            pre[0] = root;
            findPreSucRecursive(root.right, pre, suc, key);
        }
        else if(root.val > key){
            //may be a successor
            suc[0] = root;
            findPreSucRecursive(root.left, pre, suc, key);
        }
        else{
            //if a left subtree exists then predecessor is the rightmost node of the left subtree
            if(root.left != null){
                pre[0] = findJustSmaller(root.left);
            }
            //if a right subtree exists then successor is the leftmost node of the right subtree
            if(root.right != null){
                suc[0] = findJustGreater(root.right);
            }
        }
    }

    private static BinarySearchTree.Node findJustGreater(BinarySearchTree.Node root){
        BinarySearchTree.Node temp = root;
        while(temp != null && temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    private static BinarySearchTree.Node findJustSmaller(BinarySearchTree.Node root){
        BinarySearchTree.Node temp = root;
        while(temp != null && temp.right != null){
            temp = temp.right;
        }
        return temp;
    }
}
