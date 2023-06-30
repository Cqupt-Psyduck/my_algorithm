import java.util.ArrayList;

public class _74_restoreIpAddresses {
    int minLen;
    int len;
    String s;
    StringBuilder strB = new StringBuilder();
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> restoreIpAddresses (String s) {
        minLen = s.length() / 4 > 0 ? s.length() / 4 : 1;
        len = s.length();
        this.s = s;
        recursive(0, 0);
        return res;
    }

    public void recursive(int index, int cen) {
        if (cen > 3) {
            if (index == len)
                res.add(strB.substring(0, strB.length() - 1));
            return;
        }
        int maxIndex = index + 3;
        for (int i = index + minLen; i <= maxIndex && i <= len; i++) {
            String sub = s.substring(index, i);
            int value = Integer.parseInt(sub);
            if (value > 255)
                break;
            strB.append(sub).append(".");
            recursive(i, cen + 1);
            strB.delete(index + cen, i + cen + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("012"));
        //System.out.println(new _74_restoreIpAddresses().restoreIpAddresses(""));
    }
}
