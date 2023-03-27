import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SumOfThree_08 {
    private int[] nums;
    private final List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        backtrack(0,0, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(int cen, int sum, List<Integer> comp, int start) {
        if (cen == 3) {
            if (sum == 0)
                result.add(new ArrayList<>(comp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            comp.add(nums[i]);
            backtrack(cen + 1, sum, comp, i + 1);
            sum -= nums[i];
            comp.remove(comp.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;
        }
    }


    // *********************************************************上面回溯法超时，最好用双指针法

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        new SumOfThree_08().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
