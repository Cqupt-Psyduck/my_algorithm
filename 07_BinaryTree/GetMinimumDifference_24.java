public class GetMinimumDifference_24 {

    private Integer prev;
    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int left = getMinimumDifference(root.left);
        int mini = Integer.MAX_VALUE;
        if (prev != null)
            mini = Math.min(mini, root.val - prev);
        prev = root.val;
        int right = getMinimumDifference(root.right);
        return Math.min(left, Math.min(right, mini));
    }
}
