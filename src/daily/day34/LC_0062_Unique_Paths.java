package daily.day34;

import java.util.Arrays;

public class LC_0062_Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 从左到右层层遍历
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathsOnSpace(int m, int n) {
        int[] dp = new int[n];
        // 观察到当前 dp[i][j] 只依赖于 左边 dp[i][j-1] 和上面 dp[i-1][j]，可以只用一维数组：
        Arrays.fill(dp, 1); // 第一行都为 1

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
