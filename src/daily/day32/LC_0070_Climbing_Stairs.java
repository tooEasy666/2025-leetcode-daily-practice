package daily.day32;

public class LC_0070_Climbing_Stairs {

    public int climbStairs_DP(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int i, int[] memo) {
        if (i <= 1) {
            return 1;
        }
        if (memo[i] != 0) {
            return memo[i];
        }

        memo[i] = dfs(i - 1, memo) + dfs(i - 2, memo);
        return memo[i];
    }

    public int climbStairs_SpaceOn(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int climbStairs_SpaceO1(int n) {
        int f0 = 1;
        int f1 = 1;
        for (int i = 2; i <= n; i++) {
            int newF = f1 + f0;
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
