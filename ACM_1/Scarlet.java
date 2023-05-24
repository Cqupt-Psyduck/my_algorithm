import java.io.*;

public class Scarlet {

    static StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        sc.nextToken();
        int n = (int) sc.nval;
        int[][] map = new int[n][n];
        int temp = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = temp++;
            }
        }
        sc.nextToken();
        int m = (int) sc.nval;
        for (int i = 0; i < m; i++) {
            sc.nextToken();
            int x = (int) sc.nval;
            sc.nextToken();
            int y = (int) sc.nval;
            sc.nextToken();
            int r = (int) sc.nval;
            sc.nextToken();
            int z = (int) sc.nval;
            rotate(x - 1, y - 1, r, z, map);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(map[i][j]);
                out.print(' ');
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    static void rotate(int x, int y, int r, int z, int[][] map) {
        if (z == 0) {
            int temp;
            for (int i = r; i >= 0; i--) {
                for (int j = 0; j < 2 * i; j++) {
                    temp = map[x - i + j][y + i];
                    map[x - i + j][y + i] = map[x - i][y - i + j];
                    int pre = map[x + i][y + i - j];
                    map[x + i][y + i - j] = temp;
                    temp = map[x + i - j][y - i];
                    map[x + i - j][y - i] = pre;
                    map[x - i][y - i + j] = temp;
                }
            }
        } else {
            int temp;
            for (int i = r; i >= 0; i--) {
                for (int j = 0; j < 2 * i; j++) {
                    temp = map[x + i - j][y - i];
                    map[x + i - j][y - i] = map[x - i][y - i + j];
                    int pre = map[x + i][y + i - j];
                    map[x + i][y + i - j] = temp;
                    temp = map[x - i + j][y + i];
                    map[x - i + j][y + i] = pre;
                    map[x - i][y - i + j] = temp;
                }
            }
        }
    }
}
