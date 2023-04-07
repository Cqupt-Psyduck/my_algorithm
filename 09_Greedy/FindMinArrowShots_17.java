import java.util.Arrays;

public class FindMinArrowShots_17 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] == p2[0])
                return p1[1] - p2[1];
            return p1[0] > p2[0] ? 1 : -1;
        });
        int[] gap = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int count = 0;
        for (int[] point : points) {
            if (gap[1] < point[0]) {
                count++;
                gap = point;
                continue;
            }
            gap[0] = point[0];
            gap[1] = Math.min(gap[1], point[1]);
        }
        return ++count;
    }
}
