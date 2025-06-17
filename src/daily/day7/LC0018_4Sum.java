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

public class LC0018_4Sum {
    public class LC0018_FourSum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums); // 排序是前提
            return kSum(nums, 0, 4, target);
        }

        private List<List<Integer>> kSum(int[] nums, int start, int k, long target) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;

            // 剪枝：元素数量不足
            if (start >= n || k < 2) return res;

            // Base case: 两数之和
            if (k == 2) {
                int left = start, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ; // 去重
                        while (left < right && nums[right] == nums[--right]) ; // 去重
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
                return res;
            }

            // 递归 case: 转化为 k-1Sum
            for (int i = start; i < n - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // 去重

                // 剪枝优化：当前值过大/过小
                long minSum = (long) nums[i] + (long) nums[i + 1] * (k - 1);
                long maxSum = (long) nums[i] + (long) nums[n - 1] * (k - 1);
                if (minSum > target) break;
                if (maxSum < target) continue;

                for (List<Integer> subset : kSum(nums, i + 1, k - 1, target - nums[i])) {
                    List<Integer> newList = new ArrayList<>(subset); // 拷贝再添加
                    newList.add(0, nums[i]);
                    res.add(newList);
                }
            }
            return res;
        }
    }
}
