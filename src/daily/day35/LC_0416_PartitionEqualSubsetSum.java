package daily.day35;

public class LC_0416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;        // 状态定义：dp[i][j] 表示前 i 个数中，是否存在和为 j 的子集
        // 状态转移：不选 nums[i-1]：dp[i-1][j]
        //          选 nums[i-1]：dp[i-1][j - nums[i-1]]（前提 j ≥ nums[i-1]）
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
}
