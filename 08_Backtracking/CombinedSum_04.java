import java.util.ArrayList;
import java.util.List;

public class CombinedSum_04 {
    private final List<List<Integer>> result = new ArrayList<List<Integer>>();
    private int sum;
    private int num;
    public List<List<Integer>> combinationSum3(int k, int n) {
        sum = n;
        num = k;
        backtracking(new ArrayList<>(), 1, 0);
        return result;
    }

    public void backtracking(List<Integer> comb, int b, int all) {
        if (comb.size() == num && all == sum) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = b; i <= 9; i++) {
            comb.add(i);
            all += i;
            if (all > sum || comb.size() > num) {
                comb.remove(comb.size() - 1);
                return;
            }
            backtracking(comb, i + 1, all);
            all -= i;
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinedSum_04 solution = new CombinedSum_04();
        List<List<Integer>> result = solution.combinationSum3(3, 7);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
