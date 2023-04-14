import java.util.Arrays;

public class NumSquares_24 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        int square;
        for (int i = 1; (square = i * i) <= n; i++) {
            for (int j = square; j <= n; j++) {
                if (dp[j - square] != n + 1) {
                    dp[j] = Math.min(dp[j], dp[j - square] + 1);
                }
            }
        }
        return dp[n];
    }
}
