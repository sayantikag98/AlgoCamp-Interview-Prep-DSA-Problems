package BinaryTree;
import java.util.*;

//https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class MaximumWidthOfBinaryTree {
    private record Pair<F, S>(F first, S second){}

    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,3,2,5,3,null,9));
        System.out.println(widthOfBinaryTree(root));
    }

    private static int widthOfBinaryTree(Node<Integer> root) {
        /*
        Intuition taken from vertical order traversal using bfs
        just replaced column no there in vertical order traversal with the position number
        if the parent node is at position n then left child of that node will be at 2*n-1 position and
        right child of that node will be at 2*n position
        (this method of indexing I felt was better that of Striver)
        then at every level maximize the position diff (position diff for one node is that node's position and for more than 1 node the positional difference between the last node and first node)
         */
        if(root == null) return 0;
        int max = 1;
        //MADE MISTAKE
        //If you try to call peekFirst() or peekLast() on a Queue reference, the compiler will throw an error because these methods are not defined in the Queue interface.
        Deque<Pair<Node<Integer>, Integer>> nodeList = new LinkedList<>();
        nodeList.offer(new Pair<>(root, 1));
        while(!nodeList.isEmpty()){
            int size = nodeList.size();
            while(size-->0){
                Pair<Node<Integer>, Integer> pair = nodeList.poll();
                if(pair.first().left != null){
                    nodeList.offer(new Pair<>(pair.first().left, 2*pair.second()-1));

                }
                if(pair.first().right != null){
                    nodeList.offer(new Pair<>(pair.first().right, 2*pair.second()));
                }
            }
            if(!nodeList.isEmpty()){
                Pair<Node<Integer>, Integer> p1 = nodeList.peekLast(), p2 = nodeList.peekFirst();
                max = Math.max(max, p1.second()-p2.second()+1);
            }
        }
        return max;
    }
}
