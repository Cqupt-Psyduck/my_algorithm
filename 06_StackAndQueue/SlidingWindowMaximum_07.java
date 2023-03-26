import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_07 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0, j = k - 1; j < nums.length; i++,j++) {
            queue.offer(nums[j]);
            result[i] = queue.peek();
            queue.remove(nums[i]);
        }
        return result;
    }


    // 上面的超时

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>(k);
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.removeLast();
            }
            queue.add(nums[i]);
        }
        for (int i = 0, j = k - 1; j < nums.length; i++,j++) {
            while (!queue.isEmpty() && queue.getLast() < nums[j]) {
                queue.removeLast();
            }
            queue.add(nums[j]);
            result[i] = queue.peek();
            if (nums[i] == result[i])
                queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        new SlidingWindowMaximum_07().maxSlidingWindow2(new int[]{1,3,1,2,0,5}, 3);
    }
}
