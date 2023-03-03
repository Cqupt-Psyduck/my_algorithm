public class SquareArray_04 {
    // 有序数组的平方
    public int[] sortedSquares(int[] nums) {
        int[] new_nums = new int[nums.length];
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        while(index >= 0) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                new_nums[index] = nums[right] * nums[right];
                right--;
            }else {
                new_nums[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return new_nums;
    }
}
