public class HasPathSum_17 {

    private int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        if (root == null)
            return false;
        return backtrack(root, 0);
    }

    public boolean backtrack(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            return sum + node.val == target;
        }

        sum += node.val;
        if (node.left != null && backtrack(node.left, sum))
            return true;
        if (node.right != null)
            return backtrack(node.right, sum);
        return false;
    }
}
