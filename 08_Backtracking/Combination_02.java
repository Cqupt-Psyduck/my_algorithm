import java.util.ArrayList;
import java.util.List;

public class Combination_02 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(new ArrayList<>(), 1, n, k);
        return result;
    }

    public void backtracking(List<Integer> comb, int b, int n, int k) {
        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = b; i <= n; i++) {
            comb.add(i);
            backtracking(comb, i + 1, n, k);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_02 combination_02 = new Combination_02();
        List<List<Integer>> result = combination_02.combine(4, 2);
        System.out.println(result);
    }
}
