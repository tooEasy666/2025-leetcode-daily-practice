package daily.day11;

/**
 * LeetCode 347 - Top K Frequent Elements
 * Difficulty: Medium
 * Tags: Heap, HashMap, PriorityQueue
 *
 * 思路（最小堆解法）：
 * - 用 HashMap 统计每个数字出现的频率；
 * - 用大小为 k 的最小堆，维持出现频率最高的 k 个元素；
 * - 遍历频率表时维护堆的大小（超过 k 就 pop）；
 * - 最后堆中剩下的就是 top K frequent elements。
 *
 * 时间复杂度：O(N log K)
 * 空间复杂度：O(N)
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC0347_TopKFrequentHeapTemplate {

    public int[] topKFrequent(int[] nums, int k) {
        // 1. 统计频率
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. 用最小堆维持 top K 频率最高的元素
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(freqMap::get) // 比较频率大小
        );

        for (int num : freqMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 移除频率最小的元素
            }
        }

        // 3. 从堆中取出元素组成结果
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}