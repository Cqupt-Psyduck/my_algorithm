public class ConvertBST_33 {

    private int prev = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode root) {
        if (root == null) return;
        convertBST(root.right);
        root.val += prev;
        prev = root.val;
        convertBST(root.left);
    }
}
