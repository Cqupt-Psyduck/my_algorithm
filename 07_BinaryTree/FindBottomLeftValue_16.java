public class FindBottomLeftValue_16 {

    private int maxCen = 0, value;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return value;
    }

    public void dfs(TreeNode node, int cen) {
        if (node.left == null && node.right == null) {
            maxCen = Math.max(maxCen, cen);
            if (cen == maxCen) {
                value = node.val;
            }
            return;
        }
        if (node.right != null)
            dfs(node.right, cen + 1);
        if (node.left != null)
            dfs(node.left, cen + 1);
    }
}
