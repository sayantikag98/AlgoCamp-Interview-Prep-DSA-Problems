package BinaryTree;
import java.util.*;

//https://www.naukri.com/code360/problems/tree-traversal_981269
public class PreOrderInOrderAndPostOrderInOneTraversal {
    public static void main(String[] args) {
        Node<Integer> root = new BinaryTree<Integer>().binaryTreeFromArray(Arrays.asList(1,2,3,null,null,null,6));
        System.out.println(getTreeTraversalIterative(root));
        System.out.println(getTreeTraversalRecursive(root));
        System.out.println(getTreeTraversalIterative1(root));
    }

    private static List<List<Integer>> getTreeTraversalIterative(Node<Integer> root) {
        //TC = O(n), SC = O(n)
        //basically modified the post order traversal code using 1 stack for this code
        //this code was better than that of Striver
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> preOrder = new ArrayList<>(), inOrder = new ArrayList<>(), postOrder = new ArrayList<>();
        Stack<Node<Integer>> st = new Stack<>();
        Node<Integer> curr = root, prev = null;
        while(!st.empty() || curr != null){
            if(curr != null){
                //when exploring left subtree add it in the preorder list
                st.push(curr);
                preOrder.add(curr.val);
                curr = curr.left;
            }
            else{
                //when right subtree is already explored then st.peek().right == prev then it should not be added in the inorder list
                //otherwise whenever the left subtree has been explored and the right subtree is not explored then add the current peek node in the inorder list
                if(prev == null || st.peek().right != prev) inOrder.add(st.peek().val);

                //when the left subtree is explored, and we don't have a right subtree (st.peek().right == null) then add it in the postorder list
                //and also when the left subtree and the right subtree both are explored (st.peek().right == prev) then also add it in the postorder list
                if(st.peek().right == null || st.peek().right == prev){
                    //prev stores the last added node in the postorder list
                    prev = st.pop();
                    postOrder.add(prev.val);
                }
                //explore the right subtree when the left subtree has been explored
                else{
                    curr = st.peek().right;
                }
            }
        }
//        Collections.addAll(ans, inOrder, preOrder, postOrder);
        return new ArrayList<>(List.of(inOrder, preOrder, postOrder));
    }

    private static List<List<Integer>> getTreeTraversalIterative1(Node<Integer> root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> preOrder = new ArrayList<>(), inOrder = new ArrayList<>(), postOrder = new ArrayList<>();
        Stack<Pair<Node<Integer>, Integer>> st = new Stack<>();
        st.push(new Pair<>(root, 1));
        while(!st.empty()){
            Pair<Node<Integer>, Integer> topPair = st.peek();
            if(topPair.getSecond() == 1){
                preOrder.add(topPair.getFirst().val);
                topPair.setSecond(2);
                if(topPair.getFirst().left != null){
                    st.push(new Pair<>(topPair.getFirst().left, 1));
                }
            }
            else if(topPair.getSecond() == 2){
                inOrder.add(topPair.getFirst().val);
                topPair.setSecond(3);
                if(topPair.getFirst().right != null){
                    st.push(new Pair<>(topPair.getFirst().right, 1));
                }
            }
            else{
                postOrder.add(topPair.getFirst().val);
                st.pop();
            }
        }
        Collections.addAll(ans, inOrder, preOrder, postOrder);
        return ans;
    }

    private static List<List<Integer>> getTreeTraversalIterative2(Node<Integer> root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> preOrder = new ArrayList<>(), inOrder = new ArrayList<>(), postOrder = new ArrayList<>();
        Stack<Pair<Node<Integer>, Integer>> st = new Stack<>();
        st.push(new Pair<>(root, 1));
        while(!st.empty()){
            Pair<Node<Integer>, Integer> topPair = st.peek();
            if(topPair.getSecond() == 1){
                preOrder.add(topPair.getFirst().val);
                topPair.setSecond(2);
                if(topPair.getFirst().left != null){
                    st.push(new Pair<>(topPair.getFirst().left, 1));
                }
            }
            else if(topPair.getSecond() == 2){
                inOrder.add(topPair.getFirst().val);
                topPair.setSecond(3);
                if(topPair.getFirst().right != null){
                    st.push(new Pair<>(topPair.getFirst().right, 1));
                }
            }
            else{
                postOrder.add(topPair.getFirst().val);
                st.pop();
            }
        }
        Collections.addAll(ans, inOrder, preOrder, postOrder);
        return ans;
    }

    private static List<List<Integer>> getTreeTraversalRecursive(Node<Integer> root){
        List<Integer> preOrder = new ArrayList<>(), inOrder = new ArrayList<>(), postOrder = new ArrayList<>();
        helper(root, preOrder, inOrder, postOrder);
        return List.of(inOrder, preOrder, postOrder);
    }

    private static void helper(Node<Integer> root, List<Integer> preOrder, List<Integer> inOrder, List<Integer> postOrder){
        if(root == null) return;
        preOrder.add(root.val);
        helper(root.left, preOrder, inOrder, postOrder);
        inOrder.add(root.val);
        helper(root.right, preOrder, inOrder, postOrder);
        postOrder.add(root.val);
    }
}
