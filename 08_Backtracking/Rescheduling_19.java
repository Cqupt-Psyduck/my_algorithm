import java.util.*;

public class Rescheduling_19 {

    public boolean[] used;
    public List<String> result = null;
    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        ArrayList<String> comb = new ArrayList<>();
        comb.add("JFK");
        backtracking(comb, tickets, 1);
        return result;
    }
    public void backtracking(List<String> comb, List<List<String>> tickets, int index) {
        if (index == tickets.size() + 1) {
            result = new ArrayList<>(comb);
            return;
        }
        ArrayList<String[]> list = new ArrayList<>();
        // 把这一层满足要求的都找出来
        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(comb.get(index - 1))) {
                list.add(new String[] {String.valueOf(i), tickets.get(i).get(1)});
            }
        }
        // 在这里排序时间复杂度太高，可以直接对tickets排序
        // 每找到一个符合要求的直接进入递归，递归返回一个布尔值表示这条路是否能通，通了就可以直接结束
        // 从小到大排序
        list.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        for (String[] strings : list) {
            int j = Integer.parseInt(strings[0]);
            used[j] = true;
            comb.add(strings[1]);
            backtracking(comb, tickets, index + 1);
            if (result == null) {
                used[j] = false;
                comb.remove(comb.size() - 1);
            } else
                return;
        }
    }

}
