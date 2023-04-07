import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals_18 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(p -> p[0]));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                count++;
                if (intervals[i][1] > intervals[i - 1][1])
                    intervals[i] = intervals[i - 1];
            }
        }
        return count;
    }
}
