package daily.day4;

/**
 * LeetCode 0142 - LinkedListCycleII
 * Difficulty: med
 * Tags: linked list
 * CN URL: https://leetcode.cn/problems/linked-list-cycle-ii/description
 * URL: https://leetcode.com/problems/linked-list-cycle-ii/description
 *
 * Approach & 思路:
 * - 快慢指针 + 虚拟头节点，
 */

public class LC0142_LinkedListCycleII {
  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 第一步：用快慢指针判断是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // 相遇说明有环
            if (slow == fast) {
                // 第二步：从相遇点和头节点出发，再次相遇就是环起点
                ListNode index1 = head;
                ListNode index2 = slow;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1; // 或 index2 都行
            }
        }

        return null; // 无环
    }
}
