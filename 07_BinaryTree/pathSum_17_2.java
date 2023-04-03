import java.util.ArrayList;
import java.util.List;

public class pathSum_17_2 {

    private final List<List<Integer>> resultPath = new ArrayList<>();
    private int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        if (root == null)
            return resultPath;
        dfs(root, new ArrayList<>(), 0);
        return resultPath;
    }

    public void dfs(TreeNode node, List<Integer> path, int sum) {
        path.add(node.val);
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (sum == targetSum)
                resultPath.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        if (node.left != null)
            dfs(node.left, path, sum);
        if (node.right != null)
            dfs(node.right, path, sum);
        path.remove(path.size() - 1);
    }
}
