public class RemoveElement_03 {
    // 移除元素
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val)
                left++;
            else if (nums[right] != val) {
                nums[left] = nums[right];
                right--;
            }
            if (nums[right] == val)
                right--;
        }
        return left;
    }
}
