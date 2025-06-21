package daily.day11;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 239 - Sliding Window Maximum
 * Difficulty: Hard
 * Tags: Sliding Window, Monotonic Queue, Deque
 * CN URL: https://leetcode.cn/problems/sliding-window-maximum/
 * EN URL: https://leetcode.com/problems/sliding-window-maximum/
 *
 * Approach & 思路:
 * - 使用「单调队列」维护当前窗口内的最大值
 * - 每次新元素进队时，移除所有比它小的元素以保持队列单调递减（队首最大）
 * - 如果队首元素已经滑出窗口范围，则将其移除
 * - 队首始终保存当前窗口内的最大值，窗口每移动一次就记录一次结果
 *
 * 时间复杂度：O(n)，n 是输入数组 nums 的长度，即：共有多少个元素需要处理。
 * 空间复杂度：O(k)，k 是滑动窗口的大小，也就是题目中给定的参数，表示每次窗口包含的元素个数。
 */
public class LC0239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // 存下标，维护单调递减队列

        for (int i = 0; i < n; i++) {
            // Step 1: 维护队列的单调性（递减）
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);

            // Step 2: 移除已出窗口的元素
            if (i - q.getFirst() >= k) {
                q.removeFirst();
            }

            // Step 3: 窗口已形成时记录答案
            if (i >= k - 1) {
                ans[i - k + 1] = nums[q.getFirst()];
            }
        }

        return ans;
    }
}