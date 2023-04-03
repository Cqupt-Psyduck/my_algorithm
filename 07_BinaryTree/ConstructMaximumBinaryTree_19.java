import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class ConstructMaximumBinaryTree_19 {
    private int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return construct(0, nums.length);
    }

    public TreeNode construct(int begin, int end) {
        if (begin >= end)
            return null;
        int[] nodeV = getMax(begin, end);
        TreeNode root = new TreeNode(nodeV[0]);
        root.left = construct(begin, nodeV[1]);
        root.right = construct(nodeV[1] + 1, end);
        return root;
    }

    public int[] getMax(int begin, int end) {
        int[] max = new int[2];
        int num = Integer.MIN_VALUE;
        for (int i = begin; i < end; i++) {
            if (nums[i] > num) {
                num = nums[i];
                max[0] = num;
                max[1] = i;
            }
        }
        return max;
    }
}
