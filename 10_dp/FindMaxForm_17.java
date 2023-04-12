public class FindMaxForm_17 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int mCount = 0, nCount = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    mCount++;
                else
                    nCount++;
            }
            for (int i = m; i >= mCount; i--) {
                for (int j = n; j >= nCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - mCount][j - nCount] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
