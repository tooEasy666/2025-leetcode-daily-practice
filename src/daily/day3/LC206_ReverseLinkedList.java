package daily.day3;

/**
 * LeetCode 206 - ReverseLinkedList
 * Difficulty: easy
 * Tags: linked list
 * CN URL: https://leetcode.cn/problems/revese-linked-list
 * URL: https://leetcode.com/problems/revese-linked-list
 *
 * Approach & 思路:
 * - 
 */

public class LC206_ReverseLinkedList {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseList(ListNode head) {
        //cc
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next; //先把cur.next存一下
            cur.next = pre; //反转箭头
            pre = cur; //pre++
            cur = next; //cur++
        }
        return pre; //最后return pre

    }
    //T: O(n)
    //S: O(1)
}

