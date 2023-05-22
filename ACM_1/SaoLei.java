import java.util.Scanner;

public class SaoLei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = scanner.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (chars[j] == '*') {
                    padding(i, j, n - 1, m - 1, map);
                }
            }
        }
        for (int[] hang : map) {
            for (int i : hang) {
                if (i == -1)
                    System.out.print('*');
                else
                    System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void padding(int x, int y, int n, int m, int[][] map) {
        map[x][y] = -1;
        if (x - 1 >= 0) {
            if (y - 1 >= 0 && map[x - 1][y - 1] != -1)
                map[x - 1][y - 1] += 1;
            if (map[x - 1][y] != -1)
                map[x - 1][y] += 1;
            if (y + 1 <= m && map[x - 1][y + 1] != -1)
                map[x - 1][y + 1] += 1;
        }
        if (y - 1 >= 0 && map[x][y - 1] != -1)
            map[x][y - 1] += 1;
        if (y + 1 <= m && map[x][y + 1] != -1)
            map[x][y + 1] += 1;
        if (x + 1 <= n) {
            if (y - 1 >= 0 && map[x + 1][y - 1] != -1)
                map[x + 1][y - 1] += 1;
            if (map[x + 1][y] != -1)
                map[x + 1][y] += 1;
            if (y + 1 <= m && map[x + 1][y + 1] != -1)
                map[x + 1][y + 1] += 1;
        }
    }
}
