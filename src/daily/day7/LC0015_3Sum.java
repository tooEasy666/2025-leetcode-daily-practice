package daily.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 0014 - 3Sum
 * Difficulty: medium
 * Tags:
 * CN URL: https://leetcode.cn/problems/3sum
 * URL: https://leetcode.com/problems/3sum
 *
 * Approach & 思路:
 * -
 */

public class LC0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // 跳过重复值
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 提前剪枝
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue;

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]); // 去重
                    while (left < right && nums[right] == nums[--right]); // 去重
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return res;
    }
}
