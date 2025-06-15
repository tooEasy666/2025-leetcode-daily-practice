package daily.day4;

/**
 * LeetCode 0160 - IntersectionOfTwoLinkedLists
 * Difficulty: easy
 * Tags: linked list
 * CN URL: https://leetcode.cn/problems/intersection-of-two-linked-lists
 * URL: https://leetcode.com/problems/intersection-of-two-linked-lists
 *
 * Approach & 思路:
 * - 合并链表实现同步移动
 */

public class LC0160_IntersectionOfTwoLinkedLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p1 = headA, p2 = headB;

        //a为短的不重复部分，b为长的不重复部分，c为共同部分；
        //a + c + b = b + c + a
        //p1先走完a然后走c再走b，p2先走完b然后走c再走a，一定会在connect处汇合；
        while(p1 != p2){
            p1 = p1 != null? p1.next : headB;
            p2 = p2 != null? p2.next : headA;
        }
        return p1;
    }
}

