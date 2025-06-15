package daily.day4;

/**
 * LeetCode 0024 - SwapNodesInPairs
 * Difficulty: med
 * Tags: linked list
 * CN URL: https://leetcode.cn/problems/swap-nodes-in-pairs
 * URL: https://leetcode.com/problems/swap-nodes-in-pairs
 *
 * Approach & 思路:
 * - Recursion: 先Recursion后办事
 * - Iterative: 三步走，需要虚拟头节点，
 */

public class LC0024_SwapNodesInPairs {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
        dumyhead.next = head; // 将虚拟头结点指向head，这样方便后面做删除操作
        ListNode cur = dumyhead;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;
            cur.next = secondnode;       // 步骤一
            secondnode.next = firstnode; // 步骤二
            firstnode.next = temp;      // 步骤三
            cur = firstnode; // cur移动，准备下一轮交换
        }
        return dumyhead.next;
    }

    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode subHead = swapPairs(head.next.next);

        head.next.next = head;
        ListNode newHead = head.next;
        head.next = subHead;

        return newHead;
    }
}
