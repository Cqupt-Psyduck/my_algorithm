public class IsBalanced_12 {

    public boolean isBalanced(TreeNode root) {
        return countDepth(root) != -1;
    }

    public int countDepth(TreeNode node) {
        if (node == null) return 0;

        int left = countDepth(node.left);
        if (left < 0)
            return -1;
        int right = countDepth(node.right);
        if (right < 0)
            return -1;
        return Math.abs(right - left) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
