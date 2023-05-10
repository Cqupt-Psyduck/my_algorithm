import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _46_maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[]{nums[0], Integer.MIN_VALUE};
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int pre = Math.max(num, dp[0] + num);
            dp[1] = Math.max(dp[0], dp[1]);
            dp[0] = pre;
        }
        return Math.max(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        // 接收输入的整数，每个用空格隔开
        Scanner sc = new Scanner(System.in);
        List<Integer> stack = new LinkedList<>();
        String[] numbers = sc.nextLine().split(" ");
        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            int temp;
            while (true) {
                temp = isDelete(stack, num);
                if (temp == num) {
                    stack.add(0, num);
                    break;
                } else {
                    num = temp;
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.remove(0) + " ");
        }
    }

    public static int isDelete(List<Integer> stack, int num) {
        if (stack.isEmpty())
            return num;
        else {
            int sum = 0;
            for (int j = 0; j < stack.size() && sum < num; j++) {
                sum += stack.get(j);
                if (sum == num) {
                    while (j-- >= 0) {
                        stack.remove(0);
                    }
                    return num * 2;
                }
            }
        }
        return num;
    }
}
