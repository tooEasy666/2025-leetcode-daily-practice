package daily.day6;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 0001 - TwoSum
 * Difficulty: easy
 * Tags: HashMap
 * CN URL: https://leetcode.cn/problems/two-sum
 * URL: https://leetcode.com/problems/two-sum
 *
 * Approach & 思路:
 * -
 */

public class LC0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffAndIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (diffAndIndex.containsKey(diff)) {
                return new int[]{i, diffAndIndex.get(diff)};
            }
            diffAndIndex.put(nums[i], i);  // 把当前值存入map
        }

        return new int[2]; // 理论上永远不会到这一步，题目保证有解
    }

    // nums = [2,7,11,15], target = 9
    // diff = 7; map = 7, 0
    // diff = 2; map = 2, 1
}
