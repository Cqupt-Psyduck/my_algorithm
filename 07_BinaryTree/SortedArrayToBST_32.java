public class SortedArrayToBST_32 {

    private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return sortToBoth(0, nums.length - 1);
    }

    public TreeNode sortToBoth(int left, int right) {
        if (left > right)
            return null;
        int index = (left + right) / 2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = sortToBoth(left, index - 1);
        node.right = sortToBoth(index + 1, right);
        return node;
    }
}
