public class MaxProfit_37 {

    public int maxProfit(int[] prices) {
        int[] dp=new int[4];
        //状态一：持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
        //不持有股票状态，这里就有两种卖出股票状态
        //状态二：保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
        //状态三：今天卖出股票
        //状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 使用临时变量来保存dp[0], dp[2]
            // 因为马上dp[0]和dp[2]的数据都会变
            int temp = dp[0];
            int temp1 = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i-1]);
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp + prices[i-1];
            dp[3] = temp1;
        }
        return Math.max(dp[3],Math.max(dp[1],dp[2]));
    }
}
