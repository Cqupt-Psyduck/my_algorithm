import java.util.Arrays;

public class MonotoneIncreasingDigits_22 {

    // 从左向右遍历
    public int monotoneIncreasingDigits(int n) {
        char[] chars = Integer.valueOf(n).toString().toCharArray();
        int prev = Integer.MAX_VALUE;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < chars[i - 1]) {
                chars[i] = '9';
                if (prev >= i - 1) {
                    chars[i - 1] -= 1;
                    prev = i - 1;
                }
                if (i != 1)
                    i = i - 2;
            }
        }
        return Integer.parseInt(new String(chars));
    }


    // 从右向左遍历
    public int monotoneIncreasingDigits2(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
