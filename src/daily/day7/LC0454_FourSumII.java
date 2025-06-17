package daily.day7;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 0454 - FourSumII
 * Difficulty: medium
 * Tags:
 * CN URL: https://leetcode.cn/problems/4sum-ii
 * URL: https://leetcode.com/problems/4sum-ii
 *
 * Approach & 思路:
 * -
 */

public class LC0454_FourSumII {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumABCount = new HashMap<>(); // 存储 a + b 的频率
        int count = 0;

        // 枚举所有 nums1[i] + nums2[j] 的组合，并统计频次
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumABCount.put(sum, sumABCount.getOrDefault(sum, 0) + 1);
            }
        }

        // 枚举所有 nums3[i] + nums4[j] 的组合，查找是否存在 -(c + d)
        for (int c : nums3) {
            for (int d : nums4) {
                int complement = -(c + d);
                count += sumABCount.getOrDefault(complement, 0);
            }
        }

        return count;
    }
}
