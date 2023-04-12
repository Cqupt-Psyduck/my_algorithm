import java.util.Arrays;

public class FindTargetSumWays_16 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target) || (sum + target) % 2 == 1)
            return 0;
        target = (sum + target) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int one : nums) {
            for (int i = target; i >= one; i--) {
                dp[i] += dp[i - one];
            }
        }
        return dp[target];
    }
}
