import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PingPong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> _21Score = new ArrayList<>();
        List<int[]> _11Score = new ArrayList<>();
        int i = 1, j = 1;
        int win11 = 0, los11 = 0, win21 = 0, los21 = 0;
        boolean flag = false;
        do {
            char[] next = scanner.nextLine().toCharArray();
            for (char c : next) {
                switch (c) {
                    case 'W':
                        win11++;
                        win21++;
                        break;
                    case 'L':
                        los11++;
                        los21++;
                        break;
                    case 'E':
                        flag = true;
                }
                i++;
                if ((Math.max(win11, los11) >= 11 && Math.abs(win11 - los11) >= 2) || flag) {
                    _11Score.add(new int[]{win11, los11});
                    win11 = 0;
                    los11 = 0;
                    i = 1;
                }
                j++;
                if ((Math.max(win21, los21) >= 21 && Math.abs(win21 - los21) >= 2) || flag) {
                    _21Score.add(new int[]{win21, los21});
                    win21 = 0;
                    los21 = 0;
                    j = 1;
                }
                if (flag)
                    break;
            }
        } while (!flag);
        for (int[] one : _11Score)
            System.out.println(one[0] + ":" + one[1]);
        System.out.println();
        for (int[] one : _21Score)
            System.out.println(one[0] + ":" + one[1]);
    }
}
