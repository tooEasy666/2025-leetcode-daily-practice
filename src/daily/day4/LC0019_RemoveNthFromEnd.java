package daily.day4;

/**
 * LeetCode 0019 - RemoveNthFromEnd
 * Difficulty: med
 * Tags: linked list
 * CN URL: https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list
 *
 * Approach & 思路:
 * - 快慢指针，快慢指针都指向虚拟头节点这样便于通过要删除头节点的case
 * - 快指针先走n + 1步达到要删除的点, fast 和 slow 一起走，直到 fast 走到末尾, 然后删除节点
 */

public class LC0019_RemoveNthFromEnd {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast 先走 n+1 步，slow 才能停在要删除节点的前一个位置
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // fast 和 slow 一起走，直到 fast 走到末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除节点
        slow.next = slow.next.next;

        return dummy.next; // 返回新的链表头
    }
}

