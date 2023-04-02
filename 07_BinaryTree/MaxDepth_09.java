public class MaxDepth_09 {

    private int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxDepth;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
