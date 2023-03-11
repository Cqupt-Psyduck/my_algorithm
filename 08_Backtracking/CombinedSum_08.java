import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinedSum_08 {

    private int[] candidates;
    private int target;
    private List<List<Integer>> results = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        backtracking(new ArrayList<>(), 0, 0);
        return results;
    }
    public void backtracking(List<Integer> comb, int all, int index) {
        if (all == target) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            all += candidates[i];
            if (all > target) {
                break;
            }
            comb.add(candidates[i]);
            backtracking(comb, all, i + 1);
            comb.remove(comb.size() - 1);
            all -= candidates[i];
            // 去掉后面重复的，如[1,1,1,...],则第一个1已经包含了所有以1开头的可能，后续的1会重复，如[1,2,5]可能出现多次
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1])
                i++;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> results = new CombinedSum_08().combinationSum2(candidates, target);
        System.out.println(results);
    }
}
