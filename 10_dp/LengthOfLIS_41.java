import java.util.Arrays;

public class LengthOfLIS_41 {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            int j = i;
            dp[i][1] = 1;
            while (--j >= 0){
                if (nums[j] < nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        new LengthOfLIS_41().lengthOfLIS(new int[]{0,1,0,3,2,3});
    }
}
