import java.util.ArrayList;
import java.util.List;

public class SequenceTraversal_05 {
    public class TreeNode {
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
    ArrayList<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        traversal(0, root);
        return lists;
    }

    public void traversal(int cen, TreeNode node) {
        if (node == null) return;
        List<Integer> list;
        if (lists.size() - 1 < cen){
            list = new ArrayList<>();
            lists.add(list);
        } else
            list = lists.get(cen);
        list.add(node.val);
        traversal(cen + 1, node.left);
        traversal(cen + 1, node.right);
    }

}
