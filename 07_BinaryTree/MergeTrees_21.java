public class MergeTrees_21 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeNode(root1, root2);
    }

    public TreeNode mergeNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            if (node1 != null)
                return node1;
            return node2;
        }
        node1.val += node2.val;
        node1.left = mergeNode(node1.left, node2.left);
        node1.right = mergeNode(node1.right, node2.right);
        return node1;
    }
}
