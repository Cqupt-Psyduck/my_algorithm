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

    // 标准写法滑动窗口
    public int minSubArrayLen_(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
