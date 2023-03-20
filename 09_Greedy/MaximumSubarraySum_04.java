import java.util.Arrays;

public class MaximumSubarraySum_04 {

    // 暴力法
    public int maxSubArray1(int[] nums) {
        int maxSum = Arrays.stream(nums).max().getAsInt();
        int[] copy = Arrays.copyOf(nums, nums.length);
        int len = nums.length - 2;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j <= len; j++) {
                copy[j] = nums[j] + copy[j + 1];
                if (copy[j] > maxSum) {
                    maxSum = copy[j];
                }
            }
            len--;
        }
        return maxSum;
    }

    // 贪心
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumSubarraySum_04 solution = new MaximumSubarraySum_04();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
