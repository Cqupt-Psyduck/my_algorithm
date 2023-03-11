import java.util.ArrayList;
import java.util.List;

public class CombinedSum_07 {

    private int[] candidates;
    private int target;
    private List<List<Integer>> results = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backtracking(new ArrayList<Integer>(), 0, 0);
        return results;
    }

    public void backtracking(List<Integer> comb, int sum, int index) {
        if (sum == target) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) {
                sum -= candidates[i];
                continue;
            }
            comb.add(candidates[i]);
            backtracking(comb, sum, i);
            comb.remove(comb.size() - 1);
            sum -= candidates[i];
        }
    }
}
