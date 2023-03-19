import java.util.ArrayList;

public class OscillatingSequence_03 {
    public int wiggleMaxLength(int[] nums) {
        int left = nums[0], right = 0, num = nums.length + 1, i = 0;
        for (int item : nums) {
            if (left != item) {
                right = item;
                break;
            }
            i++;
            num--;
        }
        for (i++; i < nums.length; i++) {
            if (left - right > 0) {
                if (nums[i] - right <= 0) {
                    num--;
                } else {
                    left = right;
                }
            } else {
                if (nums[i] - right >= 0) {
                    num--;
                } else {
                    left = right;
                }
            }
            right = nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        OscillatingSequence_03 oscillatingSequence_03 = new OscillatingSequence_03();
        System.out.println(oscillatingSequence_03.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }
}
