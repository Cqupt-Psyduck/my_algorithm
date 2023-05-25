import java.io.*;
import java.util.ArrayList;

public class NonAggression {
    static StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);

    static int[] sit = new int[512];
    static int[] gs = new int[512];
    static int count;

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        sc.nextToken();
        n = (int) sc.nval;
        sc.nextToken();
        m = (int) sc.nval;
        sit[0] = 0; gs[0] = 0; count++;
        dfs(n, 0, 0, 0);
        long[][][] dp = new long[n][count][m + 1];
        for (int i = 0; i < count; i++)
            dp[0][i][gs[i]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    if ((sit[j] & sit[k]) > 0 || (sit[j] << 1 & sit[k]) > 0 || (sit[j] >>> 1 & sit[k]) > 0)
                        continue;
                    for (int s = m; s >= gs[j]; s--)
                        dp[i][j][s] += dp[i - 1][k][s - gs[j]];
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < count; i++)
            sum += dp[n - 1][i][m];
        out.print(sum);
        out.flush();
    }

    static void dfs(int n, int king, int base, int begin) {
        if (king >= m)
            return;
        int num = 1;
        for (int i = begin; i < n; i++) {
            int state = num << i;
            if ((base & state) != 0 || (base & (state << 1)) != 0 || (base & (state >> 1)) != 0)
                continue;
            sit[count] = base | state;
            gs[count] = king + 1;
            count++;
            dfs(n, gs[count - 1], sit[count - 1], i + 1);
        }
    }
}
