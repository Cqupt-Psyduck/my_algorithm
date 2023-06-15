import java.util.ArrayDeque;
import java.util.ArrayList;

public class _27_Print {
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        deque.addLast(pRoot);
        boolean flag = true;
        while (!deque.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = deque.size();
            if (flag) {
                while (count-- > 0) {
                    TreeNode first = deque.removeFirst();
                    list.add(first.val);
                    if (first.left != null)
                        deque.addLast(first.left);
                    if (first.right != null)
                        deque.addLast(first.right);
                }
            } else {
                while (count-- > 0) {
                    TreeNode last = deque.removeLast();
                    list.add(last.val);
                    if (last.right != null)
                        deque.addFirst(last.right);
                    if (last.left != null)
                        deque.addFirst(last.left);
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }
}
