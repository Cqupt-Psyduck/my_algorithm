import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue_14 {

    public int[][] reconstructQueue(int[][] people) {
        List<int[]> peopleList = new ArrayList<>(Arrays.asList(people));

        peopleList.sort((p1, p2) ->{
            if (p1[0] == p2[0])
                return p2[1] - p1[1];
            return p1[0] - p2[0];
        });
        for (int i = peopleList.size() - 1; i >= 0; i--) {
            if (peopleList.get(i)[1] > 0) {
                int[] temp = peopleList.get(i);
                peopleList.remove(i);
                peopleList.add(i + temp[1], temp);
            }
        }
        peopleList.toArray(people);
        return people;
    }
}
