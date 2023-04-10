public class UniquePathsWithObstacles_07 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean flag = false;
        for (int i = 0; i < paths[0].length; i++) {
            if (obstacleGrid[0][i] == 1)
                flag = true;
            if (flag)
                paths[0][i] = 0;
            else
                paths[0][i] = 1;
        }
        flag = false;
        for (int i = 0; i < paths.length; i++) {
            if (obstacleGrid[i][0] == 1)
                flag = true;
            if (flag)
                paths[i][0] = 0;
            else
                paths[i][0] = 1;
        }
        for (int i = 1; i < paths.length; i++) {
            for (int j = 1; j < paths[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                } else
                    paths[i][j] = 0;
            }
        }
        return paths[paths.length - 1][paths[0].length - 1];
    }
}
