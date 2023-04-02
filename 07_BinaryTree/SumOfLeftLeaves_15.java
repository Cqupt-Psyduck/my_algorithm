public class SumOfLeftLeaves_15 {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode node, boolean flag) {
        if (node.left == null && node.right == null) {
            if (flag)
                return node.val;
            else
                return 0;
        }

        int left = 0, right = 0;
        if (node.left != null)
            left = dfs(node.left, true);
        if (node.right != null)
            right = dfs(node.right, false);
        return left + right;
    }
}
