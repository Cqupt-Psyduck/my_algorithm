import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanPartition_13 {

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }





    // 超出内存限制
    private int sum;
    private int[] nums;
    public boolean canPartition1(int[] nums) {
        sum = Arrays.stream(nums).sum();
        this.nums = nums;
        if (sum % 2 == 1)
            return false;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        return cen(0, list);
    }

    public boolean cen(int depth, List<Integer> list) {
        if (depth == nums.length)
            return false;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) + nums[depth] == sum / 2)
                return true;
            list.add(list.get(i) + nums[depth]);
        }
        return cen(depth + 1, list);
    }

    public static void main(String[] args) {
        new CanPartition_13().canPartition(new int[]{1,5,11,5});
    }
}
