import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII_13 {

    private int[] nums;
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 必须要排序才能成功完全去重
        Arrays.sort(nums);
        this.nums = nums;
        backtracking(new ArrayList<>(), 0);
        return result;
    }

    public void backtracking(List<Integer> comb, int start) {
        result.add(new ArrayList<>(comb));

        for (int i = start; i < nums.length; i++) {
            comb.add(nums[i]);
            backtracking(comb, i + 1);
            comb.remove(comb.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
