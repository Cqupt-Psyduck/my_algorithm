import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_13 {

    private List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        if (root == null)
            return result;
        path.append(root.val);
        addPath(path, root);
        return result;
    }

    public void addPath(StringBuilder path, TreeNode node) {
        if (node.left == null && node.right == null) {
            result.add(path.toString());
            return;
        }
        if (node.left != null) {
            path.append("->").append(node.left.val);
            addPath(path, node.left);
            path.delete(path.lastIndexOf(">") - 1, path.length());
        }
        if (node.right != null) {
            path.append("->").append(node.right.val);
            addPath(path, node.right);
            path.delete(path.lastIndexOf(">") - 1, path.length());
        }
    }
}
