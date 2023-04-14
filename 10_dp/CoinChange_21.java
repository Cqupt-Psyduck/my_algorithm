import java.util.Arrays;

public class CoinChange_21 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != -1)
                    if (dp[i] == -1 || dp[i - coin] + 1 < dp[i])
                        dp[i] = dp[i - coin] + 1;
            }
        }
        return dp[amount];
    }
}
