import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionArrays_03 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] record = new int[1000];
        HashSet<Integer> list = new HashSet<>();
        for (int i : nums1) {
            record[i] = 1;
        }
        for (int i : nums2) {
            if (record[i] == 1)
                list.add(i);
        }
        int[] result = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            result[i] = iterator.next();
        }
        return result;
    }
}
