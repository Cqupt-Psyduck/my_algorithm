import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_02 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) return result;
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            result.add(node.val);
            if (node.right != null)
                deque.add(node.right);
            if (node.left != null)
                deque.add(node.left);
        }

        //traverse(root);
        return result;
    }

    public void traverse(TreeNode node) {
        if (node == null)
            return;

        result.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }
}
