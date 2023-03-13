import java.util.ArrayList;
import java.util.List;

public class Subset_11 {

    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtracking(new ArrayList<>(), 0);
        return result;
    }

    public void backtracking(List<Integer> comb, int left) {
        result.add(new ArrayList<>(comb));

        for (int i = left; i < nums.length; i++) {
            comb.add(nums[i]);
            backtracking(comb, i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset_11 subset_11 = new Subset_11();
        List<List<Integer>> subsets = subset_11.subsets(new int[]{1,2,3});
        System.out.println(subsets);
    }
}
