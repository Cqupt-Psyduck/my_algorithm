import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FullPermutation_15 {
    private List<Integer> nums_list;
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        nums_list = new ArrayList<>(nums.length);
        //Collections.addAll(nums_list, nums); 这句代码不行，因为int[]不能注入到List<Integer>中，需要包装为Integer
        for (int num : nums) {
            nums_list.add(num);
        }
        backtracking(0);
        return result;
    }

    public void backtracking(int start) {
        if (start == nums_list.size()) {
            result.add(new ArrayList<>(nums_list));
            return;
        }
        Integer exchange = nums_list.get(start);
        for (int i = start; i < nums_list.size(); i++) {
            nums_list.set(start, nums_list.get(i));
            nums_list.set(i, exchange);
            backtracking(start + 1);
            nums_list.set(i, nums_list.get(start));
            nums_list.set(start, exchange);
        }
    }
}
