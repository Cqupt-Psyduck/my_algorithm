import java.util.ArrayList;

public class _5_longestPalindrome {

    public String longestPalindrome(String s) {
        boolean[] dp = new boolean[s.length()];
        int max = 0;
        int l = 0, r = 0;
        int left = s.length();
        while (--left >= 0) {
            for (int i = s.length() - 1; i >= left; i--) {
                switch (i - left) {
                    case 0:
                        dp[i] = true;
                        break;
                    case 1:
                        dp[i] = s.charAt(left) == s.charAt(i);
                        break;
                    default:
                        dp[i] = s.charAt(left) == s.charAt(i) && dp[i - 1];
                }
                if (dp[i] && i - left + 1 > max) {
                    max = i - left + 1;
                    l = left;
                    r = i;
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public String longestPalindrome1(String s) {
        int max = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            int j = 1, l = i, r = i + 1;
            while (i + j < s.length() && i - j >= 0) {
                if (s.charAt(i + j) == s.charAt(i - j)) {
                    len += 2;
                    l--; r++; j++;
                } else
                    break;
            }
            if (len > max) {
                max = len;
                left = l;
                right = r;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1))
                continue;
            int len = 2;
            int j = 1, l = i, r = i + 2;
            while (i + j + 1 < s.length() && i - j >= 0) {
                if (s.charAt(i + j + 1) == s.charAt(i - j)) {
                    len += 2;
                    l--; r++; j++;
                }
                else
                    break;
            }
            if (len > max) {
                max = len;
                left = l;
                right = r;
            }
        }
        return s.substring(left, right);
    }

    public static void main(String[] args) {
        System.out.println(new _5_longestPalindrome().longestPalindrome1("babad"));
    }
}
