public class DeleteNode_30 {
    private TreeNode prev;
    private boolean flag;
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (prev == null) {
                TreeNode node = findMin(root.right);
                if (node != null) {
                    node.left = root.left;
                    return root.right;
                } else {
                    return root.left;
                }
            }
            else {
                TreeNode newNode;
                TreeNode node = findMin(root.right);
                if (node != null) {
                    node.left = root.left;
                    newNode = root.right;
                }
                else {
                    newNode = root.left;
                }
                if (flag)
                    prev.left = newNode;
                else
                    prev.right = newNode;
            }
        }
        prev = root;
        if (key > root.val) {
            flag = false;
            deleteNode(root.right, key);
        }
        else if (key < root.val) {
            flag = true;
            deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        if (node == null)
            return null;
        if (node.left == null)
            return node;
        else
            return findMin(node.left);
    }
}
