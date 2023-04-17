public class MaxProfit_34 {

    public int maxProfit_carl(int[] prices) {
        int[] dp = new int[2];
        // 0表示持有，1表示卖出
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 前一天持有; 既然不限制交易次数，那么再次买股票时，要加上之前的收益
            dp[0] = Math.max(dp[0], dp[1] - prices[i-1]);
            // 前一天卖出; 或当天卖出，当天卖出，得先持有
            dp[1] = Math.max(dp[1], dp[0] + prices[i-1]);
        }
        return dp[1];
    }
    public int maxProfit(int[] prices) {
        int[] dp = new int[]{prices[0], 0};
        for (int price : prices) {
            dp[1] = Math.max(price - dp[0] + dp[1], dp[1]);
            dp[0] = price;
        }
        return dp[1];
    }
}
