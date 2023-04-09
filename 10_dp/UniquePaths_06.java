import java.util.Arrays;

public class UniquePaths_06 {
    public int uniquePaths(int m, int n) {
        int[][] stable = new int[m][n];
        for (int i = 0; i < n; i++) {
            stable[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            stable[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                stable[i][j] = stable[i - 1][j] + stable[i][j - 1];
            }
        }
        return stable[m - 1][n - 1];
    }
}
