package daily.day32;

import java.util.Arrays;

public class LC_0746_Min_Cost_Climbing_Stairs{
    public int minCostClimbingStairs_DP(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // -1 表示没有计算过
        return dfs(n, memo, cost);
    }

    private int dfs(int i, int[] memo, int[] cost) {
        if (i <= 1) { // 递归边界
            return 0;
        }
        if (memo[i] != -1) { // 之前计算过
            return memo[i];
        }
        int res1 = dfs(i - 1, memo, cost) + cost[i - 1];
        int res2 = dfs(i - 2, memo, cost) + cost[i - 2];
        return memo[i] = Math.min(res1, res2); // 记忆化
    }

    public int minCostClimbingStairs_DT(int[] cost) {
        int f0 = 0, f1 = 0;
        for (int i = 1; i < cost.length; i++) {
            int newF = Math.min(f1 + cost[i], f0 + cost[i - 1]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
