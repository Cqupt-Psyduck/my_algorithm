import java.util.Arrays;

public class ReverseStringII_02 {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int left, right;
        for (int i = 0; i < s.length() - s.length() % (2 * k); i += 2 * k) {
            left = i;
            right = i + k - 1;
            while (left <= right) {
                str[left] = s.charAt(right);
                str[right] = s.charAt(left);
                left++;
                right--;
            }
        }
        left = s.length() - s.length() % (2 * k);
        right = s.length() % (2 * k) - k >= 0 ? left + k - 1 : s.length() - 1;
        while (left <= right) {
            str[left] = s.charAt(right);
            str[right] = s.charAt(left);
            left++;
            right--;
        }
        return new String(str);
    }
}
