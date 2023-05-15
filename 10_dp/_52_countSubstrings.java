public class _52_countSubstrings {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        boolean[] dp = new boolean[chars.length];
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i] = true;
            sum++;
            if (i + 1 < chars.length) {
                if (chars[i] == chars[i + 1])
                    sum++;
                else
                    dp[i + 1] = false;
            }
            boolean pre = true;
            for (int j = i + 2; j < chars.length; j++) {
                if (chars[i] == chars[j] && pre) {
                    pre = dp[j];
                    dp[j] = true;
                    sum++;
                } else {
                    pre = dp[j];
                    dp[j] = false;
                }
            }
        }
        return sum;
    }
}
