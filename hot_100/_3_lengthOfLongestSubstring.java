import java.util.Arrays;

public class _3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals(""))
            return 0;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int pre = dp[i - 1];
            int count = 1;
            for (int j = i - 1; j >= i - pre; j--) {
                if (chars[j] == chars[i])
                    break;
                count++;
            }
            dp[i] = count;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
