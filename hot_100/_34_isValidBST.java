import java.util.ArrayDeque;

public class _34_isValidBST {
    public boolean isValidBST (TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int pre = Integer.MIN_VALUE;
        if (root == null)
            return true;
        stack.push(root);
        root = root.left;
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.pop();
                if (root.val <= pre)
                    return false;
                pre = root.val;
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return true;
    }
}
