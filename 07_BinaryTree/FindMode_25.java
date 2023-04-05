import java.util.*;

public class FindMode_25 {

    private Integer prev;
    private int maxCount = 0;
    private int count = 1;
    private final List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ints = new int[result.size()];
        int i = 0;
        for ( Integer val : result) {
            ints[i] = val;
            i++;
        }
        return ints;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (prev != null) {
            if (prev == node.val)
                count++;
            else
                count = 1;
        } else
            count = 1;
        prev = node.val;
        if (maxCount == count) {
            result.add(node.val);
        }
        if (maxCount < count) {
            result.clear();
            result.add(node.val);
            maxCount = count;
        }
        dfs(node.right);
    }
}
