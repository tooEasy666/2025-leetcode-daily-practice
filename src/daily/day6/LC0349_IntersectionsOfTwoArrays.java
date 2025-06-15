package daily.day6;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 0349 - IntersectionsOfTwoArrays
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/intersection-of-two-arrays
 * URL: https://leetcode.com/problems/intersection-of-two-arrays
 *
 * Approach & 思路:
 * - 用两个set处理
 */

public class LC0349_IntersectionsOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int n : nums1) {
            nums1Set.add(n);
        }

        Set<Integer> res = new HashSet<>();
        for (int n : nums2) {
            if (nums1Set.contains(n)) {
                res.add(n);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
