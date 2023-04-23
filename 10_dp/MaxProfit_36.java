public class MaxProfit_36 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][2];
        for (int i = 1; i < dp.length; i++)
            dp[i][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
        }
        return dp[k][1];
    }
}
