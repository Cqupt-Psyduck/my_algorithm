import java.util.ArrayList;
import java.util.List;

public class SplitPalindromeString_09 {

    private List<List<String>> result = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        backtracking(new ArrayList<>(), s);
        return result;
    }

    public boolean isPalindromeString(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void backtracking(List<String> comb, String str) {
        if (str == null || str.length() == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(left, i + 1);
            if (isPalindromeString(substring)) {
                comb.add(substring);
                // subString若超过了str长度返回一个空字符串
                backtracking(comb, str.substring(i + 1));
                comb.remove(comb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SplitPalindromeString_09 splitPalindromeString_09 = new SplitPalindromeString_09();
        List<List<String>> result = splitPalindromeString_09.partition("aab");
        System.out.println(result);
    }
}
