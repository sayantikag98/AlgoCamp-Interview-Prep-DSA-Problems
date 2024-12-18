package BinaryTree;
import java.util.*;

//https://www.interviewbit.com/problems/path-to-given-node/
public class PathToGivenNode {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,4,5,null,6));
        System.out.println(Arrays.toString(solve(root, 6)));
    }
    private static int[] solve(Node<Integer> A, int B) {
        List<Integer> lans = new ArrayList<>();
//        isPathFound(A, B, lans);
        isPathFoundAnotherImplementation(A, B, lans);
        int[] ans = new int[lans.size()];
        int k = 0;
        for(int ele: lans){
            ans[k++] = ele;
        }
        return ans;
    }

    private static boolean isPathFound(Node<Integer> root, int B, List<Integer> lans){
        //Backtracking
        if(root == null) return false;
        if(root.val == B){
            lans.add(root.val);
            return true;
        }
        lans.add(root.val);
        //if i found a path from left or from right no need to call for recursion further so return
        boolean ans = isPathFound(root.left, B, lans);
        if(ans) return true;
        ans = isPathFound(root.right, B, lans);
        if(ans) return true;
        //if i did not find a path from left and from right then that node is not in my valid path so remove it from list
        lans.removeLast();
        return ans;
    }

    private static boolean isPathFoundAnotherImplementation(Node<Integer> root, int B, List<Integer> lans){
        //Backtracking
        //TC = O(n), SC = O(n)
        if(root == null) return false;

        lans.add(root.val);

        if(root.val == B) return true;

        //if i found a path from left or from right no need to call for recursion further so return
        if(isPathFoundAnotherImplementation(root.left, B, lans) || isPathFoundAnotherImplementation(root.right, B, lans)) return true;
        //if i did not find a path from left and from right then that node is not in my valid path so remove it from list
        lans.removeLast();
        return false;
    }
}
