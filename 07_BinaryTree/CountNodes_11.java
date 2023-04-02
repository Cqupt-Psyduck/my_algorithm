public class CountNodes_11 {

    private int maxCen = 0;
    private int lastCount = 0;
    public int countNodes(TreeNode root) {
        dfs(root, 0);
        return (int) (Math.pow(2, maxCen - 1) + lastCount);
    }

    public boolean dfs(TreeNode node, int cen) {
        if (node == null) {
            maxCen = Math.max(maxCen, cen);
            if (cen == maxCen) {
                lastCount++;
                return false;
            } else
                return true;
        }
        if (dfs(node.left, cen + 1))
            return true;
        return dfs(node.right, cen + 1);
    }

}
