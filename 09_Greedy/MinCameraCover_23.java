public class MinCameraCover_23 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int count = 0;
    // boolean数组第一个值表示是否要求父节点安装摄像头
    // 第二个值表示自身是否安装了摄像头
    private boolean[] a = new boolean[]{false, true},
    b = new boolean[]{false, false},
    c = new boolean[]{true, false};
    public int minCameraCover(TreeNode root) {
        return isInstall(root)[0] ? count + 1 : count;
    }

    public boolean[] isInstall(TreeNode node) {
        if (node == null)
            return b;
        boolean[] left = isInstall(node.left);
        boolean[] right = isInstall(node.right);
        if (left[0] || right[0]) {
            count++;
            return a;
        } else if (left[1] || right[1])
            return b;
        return c;
    }
}
