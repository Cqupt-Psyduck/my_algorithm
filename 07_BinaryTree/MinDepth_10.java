import java.util.LinkedList;

public class MinDepth_10 {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> cen = new LinkedList<>();
        cen.add(root);
        int depth = 1;
        while (true) {
            int size = cen.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = cen.poll();
                if (node.left == null && node.right == null)
                    return depth;
                else {
                    if (node.left != null)
                        cen.add(node.left);
                    if (node.right != null)
                        cen.add(node.right);
                }
            }
            depth++;
        }
    }

}
