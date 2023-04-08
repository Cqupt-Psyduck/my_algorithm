import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_19 {
    public List<Integer> partitionLabels(String s) {
        int max = 0, prev = -1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, s.lastIndexOf(s.charAt(i)));
            if (max == i) {
                result.add(i - prev);
                prev = i;
            }
        }
        return result;
    }
}
