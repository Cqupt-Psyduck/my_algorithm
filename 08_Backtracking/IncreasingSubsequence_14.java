import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IncreasingSubsequence_14 {

    private int[] nums;
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        backtracking(new ArrayList<>(), 0);
        return result;
    }

    public void backtracking(List<Integer> comb, int start) {
        if (comb.size() > 1) {
            result.add(new ArrayList<>(comb));
        }
        // 特殊去重：不用排序，直接记录本层之前使用过的，下次不再使用。
        // 这是因为有递增或递减这种要求，所以不会有[2,2,3]和[2,3,2]同时满足要求添加到result的情况，之前的题却会出现这种情况，所以不能这样去重
        // 只能先排序再while跳过
        // 由于nums中值的范围在-100到100之间，可以new int[201]代替new HashSet<>()，这样比set.add更快，但相对耗费空间也将更多
        HashSet<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if ((comb.size() == 0 || comb.get(comb.size() - 1) <= nums[i]) && !used.contains(nums[i])) {
                comb.add(nums[i]);
                used.add(nums[i]);
                backtracking(comb, i + 1);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
