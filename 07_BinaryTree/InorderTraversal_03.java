import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_03 {
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
    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> queue = new Stack<>();
        if (root == null) return result;
        do {
            if (root != null) {
                queue.add(root);
                root = root.left;
            } else {
                root = queue.pop();
                result.add(root.val);
                root = root.right;
                if (root != null) {
                    queue.add(root);
                    root = root.left;
                }
            }
        } while (!queue.isEmpty());

        //traverse(root);
        return result;
    }

    public void traverse(TreeNode node) {
        if (node == null)
            return;
        traverse(node.left);
        result.add(node.val);
        traverse(node.right);
    }
}
