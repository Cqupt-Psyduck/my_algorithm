public class InsertIntoBST_29 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else
                insertIntoBST(root.right, val);
        }
        if (val < root.val) {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                insertIntoBST(root.left, val);
        }
        return root;
    }
}
