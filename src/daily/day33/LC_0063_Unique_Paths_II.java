package daily.day33;

public class LC_0063_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        // 初始化第一格
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // 有障碍，无法到达
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // 状态转移：从左边和上面来
                }
                // j == 0 时不加 dp[j-1]，因为越界，只继承 dp[j]（上一行）
            }
        }

        return dp[n - 1];
    }
}
