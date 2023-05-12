import java.util.Arrays;

public class _50_minDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
            dp[0][i] = i;
        for (int i = 1; i <= word2.length(); i++)
            dp[i][0] = i;
        for (int i = 1; i <= word2.length(); i++) {
            for (int j = 1; j <= word1.length(); j++) {
                if (word1.charAt(j - 1) == word2.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    // dp[i - 1][j - 1]的情况即为替换元素的情况，我是个傻逼
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[word2.length()][word1.length()];
    }
}
