public class _53_longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            int pre = 0;
            if (i + 1 < chars.length)
                pre = dp[i + 1];
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1)
                        dp[j] = j - i + 1;
                    else {
                        int temp = dp[j];
                        dp[j] = pre + 2;
                        pre = temp;
                    }
                } else {
                    if (j - i == 1)
                        dp[j] = 1;
                    else {
                        int temp = dp[j];
                        dp[j] = Math.max(dp[j - 1], dp[j]);
                        pre = temp;
                    }
                }
            }
        }
        return dp[chars.length - 1];
    }
}
