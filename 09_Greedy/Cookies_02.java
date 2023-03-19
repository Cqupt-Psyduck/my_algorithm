import java.util.Arrays;

public class Cookies_02 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0, index = 0;
        for (int value : g) {
            while (index < s.length && value > s[index]) {
                index++;
            }
            if (index == s.length)
                break;
            num++;
            index++;
        }
        return num;
    }
}
