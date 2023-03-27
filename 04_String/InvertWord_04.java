public class InvertWord_04 {
    public String reverseWords(String s) {
        int len = s.length() - 1, i;
        StringBuilder str = new StringBuilder();
        while (len >= 0) {
            if (s.charAt(len) == ' ') {
                len--;
                continue;
            }
            i = len;
            while (len > 0 && s.charAt(len - 1) != ' ') {
                len--;
            }
            str.append(s, len, i + 1).append(' ');
            len--;
        }
        return str.deleteCharAt(str.length() - 1).toString();
    }
}
