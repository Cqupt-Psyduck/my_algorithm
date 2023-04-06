import java.util.Arrays;

public class LargestSumAfterKNegations_09 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; k > 0; k--, i++) {
            if (i < nums.length && nums[i] <= 0) {
                nums[i] = -nums[i];
            } else {
                int index;
                if (i == nums.length || (i > 0 && nums[i - 1] < nums[i])) {
                    index = i - 1;
                } else
                    index = i;
                if (k % 2 == 1)
                    nums[index] = -nums[index];
                k = 0;
            }
        }
        return Arrays.stream(nums).sum();
    }
}
