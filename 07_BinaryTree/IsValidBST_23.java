public class IsValidBST_23 {

    private boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        findZui(root);
        return isValid;
    }

    public int[] findZui(TreeNode node) {
        int[] ints = new int[]{node.val, node.val};
        if (node.left == null && node.right == null)
            return ints;
        int nodeVal = node.val;
        int[] left = new int[]{nodeVal, nodeVal};
        int[] right = new int[]{nodeVal, nodeVal};
        if (node.left != null) {
            left = findZui(node.left);
            if (!isValid)
                return null;
            if (left[1] >= nodeVal)
                isValid = false;
        }
        if (!isValid)
            return null;
        if (node.right != null) {
            right = findZui(node.right);
            if (!isValid)
                return null;
            if (right[0] <= nodeVal)
                isValid = false;
        }
        if (!isValid)
            return null;
        ints[0] = left[0];
        ints[1] = right[1];
        return ints;
    }
}
