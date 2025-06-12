package daily.day2;

/**
 * LeetCode  - LC0209_MinimumSizeSubarraySum
 * Difficulty: medium
 * Tags: sliding window
 * CN URL: https://leetcode.cn/problems/minimum-size-subarray-sum/
 * URL: https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Approach & 思路:
 * - 核心思想是先移动右，到大于目标之后固定右，移动左，找到最小的符合条件的数组长度
 */

public class LC0209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1; // 把答案初始化为比nums的长度更长的数
        int sum = 0; // sum of the sub array
        int left = 0; // left index of sub array
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            // 只在当当前sum比目标大的时候做操作 -> 移动左指针以及从sum里删减数
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans <= n ? ans : 0;
    }
}
