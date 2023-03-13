import java.util.ArrayList;
import java.util.List;

public class RecoveryIP_10 {

    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(new StringBuilder(), s, 0);
        return result;
    }

    public void backtracking(StringBuilder comb, String str, int count) {
        if (count == 4) {
            if (str.length() == 0) {
                comb.deleteCharAt(comb.length() - 1);
                result.add(comb.toString());
                comb.append(".");
            }
            return;
        }

        for (int i = 0; i < str.length() && i < 3; i++) {
            if (str.charAt(0) == '0') {
                comb.append("0.");
                backtracking(comb, str.substring(1), count + 1);
                comb.delete(comb.length() - 2, comb.length());
                break;
            }
            String subStr = str.substring(0, i + 1);
            if (Integer.parseInt(subStr) - 255 <= 0) {
                comb.append(subStr).append(".");
                backtracking(comb, str.substring(i + 1), count + 1);
                comb.delete(comb.length() - subStr.length() - 1, comb.length());
            } else
                break;
        }
    }
}
