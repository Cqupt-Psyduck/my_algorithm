public class RepeatedSubstring_07 {

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1)
            return false;
        String str = s + s;
        String substring = str.substring(1, str.length() - 1);
        return substring.contains(s);
    }

    // KMP法求解

    public boolean repeatedSubstringPatternKMP(String s) {
        if (s.length() == 1)
            return false;
        int[] next = new int[s.length()];
        next[0] = 0;
        int left = 0;
        for (int right = 1; right < s.length(); right++) {
            while (left > 0 && s.charAt(right) != s.charAt(left))
                left = next[left - 1];
            if (s.charAt(left) == s.charAt(right))
                left++;
            next[right] = left;
        }
        int len = s.length() - next[s.length() - 1];
        return len <= s.length() / 2 && s.length() % len == 0;
    }

    public static void main(String[] args) {
        RepeatedSubstring_07 repeatedSubstringPattern = new RepeatedSubstring_07();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPatternKMP("abac"));
    }
}
