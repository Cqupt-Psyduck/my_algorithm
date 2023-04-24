import java.util.Arrays;

public class FindLengthOfLCIS_42 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else
                dp[i] = 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
