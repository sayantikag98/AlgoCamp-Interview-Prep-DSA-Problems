package BinaryTree;

class BinarySearchTree{
    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    BinarySearchTree(){
        this.root = null;
    }

    Node addNode(int val){
        Node newNode = new Node(val);
        if(this.root == null) {
            this.root = newNode;
        }
        else{
            Node curr = this.root;
            while(curr != null){
                if(curr.val == val) break;
                if(curr.val < val){
                    if(curr.right == null) {
                        curr.right = newNode;
                    }
                    curr = curr.right;
                }
                else{
                    if(curr.left == null) {
                        curr.left = newNode;
                    }
                    curr = curr.left;
                }
            }
        }
        return this.root;
    }

    Node deleteNode(Node root, int key) {
        if(root == null) return this.root;
        if(root.val == key){
            this.root = helper(root);
            return this.root;
        }
        Node curr = root;
        //finding the node having value as key 
        while(curr != null && curr.val != key){
            if(curr.val < key){
                if(curr.right != null && curr.right.val == key){
                    curr.right = helper(curr.right);
                    break;
                }
                curr = curr.right;
            }
            else{
                if(curr.left != null && curr.left.val == key){
                    curr.left = helper(curr.left);
                    break;
                }
                curr = curr.left;
            }
        }
        return this.root;
    }
    
    Node deleteNode(int key){
        return this.deleteNode(this.root, key);
    }


    private Node helper(Node curr){
        if(curr.left == null) return curr.right;
        Node temp = curr.left, prev = curr;
        while(temp.right != null){
            prev = temp;
            temp = temp.right;
        }
        curr.val = temp.val;
        if(prev != curr) prev.right = temp.left;
        else prev.left = temp.left;

        return curr;
    }

    void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    void inorder(){
        this.inorder(this.root);
    }
}

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(10);
        bst.addNode(4);
        bst.addNode(13);
        bst.addNode(5);
        bst.addNode(8);
        bst.addNode(15);
        bst.inorder();
        bst.deleteNode(4);
        System.out.println();
        bst.inorder();
        bst.deleteNode(10);
        System.out.println();
        bst.inorder();
    }
}
