import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_20 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(p -> p[0]));
        List<int[]> result = new ArrayList<>();
        int begin = intervals[0][0], end = intervals[0][1];
        for (int[] interval : intervals) {
            if (end < interval[0]) {
                result.add(new int[]{begin, end});
                begin = interval[0];
                end = interval[1];
            } else
                end = Math.max(interval[1], end);
        }
        result.add(new int[]{begin, end});
        return result.toArray(new int[result.size()][]);
    }
}
