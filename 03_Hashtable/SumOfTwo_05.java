import java.util.HashMap;
import java.util.Map;

public class SumOfTwo_05 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        int left = 0, right = -1;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            left = item.getKey();
            if (map.containsValue(target - item.getValue())) {
                for (int i = 0; i < nums.length; i++) {
                    if (target - item.getValue() == map.get(i) && left != i)
                        right = i;
                }
                if (right != -1)
                    break;
            }
        }
        return new int[]{left, right};
    }
}
