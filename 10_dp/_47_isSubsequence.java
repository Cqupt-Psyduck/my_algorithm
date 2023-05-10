public class _47_isSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : s.toCharArray()) {
            while (i < t.length() && t.charAt(i) != c){i++;};
            if (i == t.length())
                return false;
            i++;
        }
        return true;
    }
}
