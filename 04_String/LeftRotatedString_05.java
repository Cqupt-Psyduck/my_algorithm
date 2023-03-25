import java.util.Arrays;

public class LeftRotatedString_05 {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        char[] reverse = new char[n];
        System.arraycopy(chars, 0, reverse, 0, n);
        System.arraycopy(chars, n, chars, 0, chars.length - n);
        System.arraycopy(reverse, 0, chars, chars.length - n, n);
        //for (int i = 0; i < chars.length - n; i++) {
        //    chars[i] = chars[i + n];
        //}
        //for (int i = chars.length - n, j = 0; i < chars.length; i++, j++) {
        //    chars[i] = reverse[j];
        //}
        return new String(chars);
    }

    public static void main(String[] args) {
        LeftRotatedString_05 solution = new LeftRotatedString_05();
        System.out.println(solution.reverseLeftWords("lrloseumgh", 6));
    }
}
