import java.util.*;

public class HighFrequencyElement_08 {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        HashMap<Integer, Integer> record = new HashMap<>();
        HashSet<Integer> set = new HashSet<>(k);
        int count = 0;
        for (int num : nums) {
            if (record.containsKey(num)) {
                count = record.get(num) + 1;
                record.replace(num, count);
            } else {
                count = 1;
                record.put(num, count);
            }
            if (set.contains(num))
                continue;
            if (queue.size() < k || queue.peek()[1] < count) {
                if (queue.size() >= k) {
                    int[] o = queue.poll();
                    while (o[1] != record.get(o[0])) {
                        o[1] = record.get(o[0]);
                        queue.add(o);
                        o = queue.poll();
                    }
                    set.remove(o[0]);
                }
                queue.add(new int[]{num, count});
                set.add(num);
            }
        }
        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
