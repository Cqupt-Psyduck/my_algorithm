import java.util.ArrayList;
import java.util.List;

public class WordBreak_26 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String str : wordDict) {
                int len = str.length();
                if (len > i)
                    continue;
                boolean flag = true;
                for (int j = i, h = len; j > i - len; j--, h--) {
                    if (s.charAt(j - 1) != str.charAt(h - 1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag & dp[i - len])
                    dp[i] = true;
            }
        }
        return dp[dp.length - 1];
    }
}
