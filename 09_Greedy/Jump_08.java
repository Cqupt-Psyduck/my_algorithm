public class Jump_08 {

    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int max = nums[0], count = 0, currentMax = -1;
        for (int i = 0; i < nums.length; i++) {
            if (currentMax < nums[i] + i)
                currentMax = nums[i] + i;
            if (i == max || i == nums.length - 1) {
                max = currentMax;
                count++;
            }
        }
        return count;
    }
}
