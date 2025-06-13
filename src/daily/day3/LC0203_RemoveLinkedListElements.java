package daily.day3;

/**
 * LeetCode 0203 - RemoveLinkedListElements
 * Difficulty: easy
 * Tags: linkedList, recursion
 * CN URL: https://leetcode.cn/problems/remove-linked-list-elements
 * URL: https://leetcode.com/problems/remove-linked-list-elements
 *
 * Approach & 思路:
 * - recursion的方式很优雅， iteration的方法是添加一个虚拟头节点
 */

public class LC0203_RemoveLinkedListElements {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 虚拟头节点的方法，注意用 pre 指向当前节点的前一个节点；
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur != null) {
            if (cur.val == val) {
                ListNode temp = cur.next;
                pre.next = temp;
                cur = temp;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // 递归的方法：
    public ListNode removeElementsRecursion(ListNode head, int val) {
        if(head == null)
            return null; // base case：空链表

        head.next = removeElements(head.next, val); // 先处理后面部分
        if(head.val == val) {
            return head.next; // 跳过当前节点
        }
        else {
            return head;      // 保留当前节点
        }
    }
}
