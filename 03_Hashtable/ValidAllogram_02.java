import java.util.Arrays;

public class ValidAllogram_02 {

    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        Arrays.fill(record,0);
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int j : record) {
            if (j != 0)
                return false;
        }
        return true;
    }
}
