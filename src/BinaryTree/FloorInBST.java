package BinaryTree;
import java.util.*;

//https://www.naukri.com/code360/problems/floor-from-bst_920457
public class FloorInBST {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(10, 5, 1, 2, 6));
        System.out.println(floorInBST(root, 4));
    }
    private static int floorInBST(Node<Integer> root, int x) {
        //TC = O(log n), SC = O(1)
        int floor = -1;
        Node<Integer> curr = root;
        while(curr != null){
            if(curr.val == x){
                floor = x;
                break;
            }
            if(curr.val < x){
                floor = curr.val;
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        return floor;
    }
}
