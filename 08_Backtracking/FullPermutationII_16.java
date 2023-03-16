import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullPermutationII_16 {
    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] booleans;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        booleans = new boolean[nums.length];
        backtracking(new ArrayList<>());
        return result;
    }

    public void backtracking(List<Integer> comb) {
        if (comb.size() == nums.length) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (booleans[i])
                continue;
            booleans[i] = true;
            comb.add(nums[i]);
            backtracking(comb);
            comb.remove(comb.size() - 1);
            booleans[i] = false;
            while (i + 1 < nums.length && nums[i] == nums[i + 1])
                i++;
        }
    }
}
