import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NQueen_20 {

    private List<List<String>> result = new ArrayList<>();
    private int n;
    private boolean[] used;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        used = new boolean[n];
        backtracking(new ArrayList<>(), 0);
        return result;
    }

    public void backtracking(List<String> comb, int ceng) {
        if (ceng == n) {
            result.add(new ArrayList<>(comb));
            return;
        }
        char[] ch = new char[n - 1];
        Arrays.fill(ch, '.');
        StringBuilder str = new StringBuilder().append(ch);
        for (int i = 0; i < n; i++) {
            if (!used[i] && available(comb, ceng, i)) {
                str.insert(i, 'Q');
                used[i] = true;
                comb.add(str.toString());
                backtracking(comb, ceng + 1);
                comb.remove(comb.size() - 1);
                used[i] = false;
                str.deleteCharAt(i);
            }
        }
    }

    public static boolean available(List<String> comb, int ceng, int lie) {
        for (int i = 0; i < comb.size(); i++) {
            int index = comb.get(i).indexOf("Q");
            if (index - lie == i - ceng || index - lie == ceng - i)
                return false;
        }
        return true;
    }
}
