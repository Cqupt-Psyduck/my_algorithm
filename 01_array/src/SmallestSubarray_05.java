import java.util.Arrays;

public class SmallestSubarray_05 {
    // 长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        int sum = nums[0], j = 0;
        while (sum < target && j < nums.length - 1){
            sum += nums[++j];
        }
        if (sum < target)
            return 0;
        int len = j + 1;
        for (int i = 1; i < nums.length; i++) {
            sum -= nums[i-1];
            while (sum < target && j < nums.length - 1){
                sum += nums[++j];
            }
            if (sum < target)
                return len;
            else if (j - i + 1 < len)
                len = j - i + 1;
        }
        return len;
    }
}
