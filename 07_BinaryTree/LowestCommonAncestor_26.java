public class LowestCommonAncestor_26 {

    int nodeP, nodeQ;
    TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        nodeP = p.val;
        nodeQ = q.val;
        dfs(root);
        return ancestor;
    }

    public int[] dfs(TreeNode node) {
        int[] flag = new int[]{0, 0};
        if (node == null)
            return flag;
        // 左
        flag = dfs(node.left);
        if (flag[0] == 1 && flag[1] == 1) {
            if (ancestor == null)
                ancestor = node;
            return flag;
        }

        // 中
        if (node.val == nodeP)
            flag[0] = 1;
        if (node.val == nodeQ)
            flag[1] = 1;
        if (flag[0] == 1 && flag[1] == 1) {
            if (ancestor == null)
                ancestor = node;
            return flag;
        }

        // 右
        int[] right = dfs(node.right);
        if (right[0] == 1)
            flag[0] = 1;
        if (right[1] == 1)
            flag[1] = 1;
        if (flag[0] == 1 && flag[1] == 1) {
            if (ancestor == null)
                ancestor = node;
            return flag;
        }
        return flag;
    }
}
