import java.util.ArrayList;
import java.util.PriorityQueue;

public class _46_GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : input)
            priorityQueue.offer(i);
        ArrayList<Integer> result = new ArrayList<>();
        while (k-- > 0)
            result.add(priorityQueue.poll());
        return result;
    }
}
