package daily.day3;

/**
 * LeetCode 707 - Design Linked List
 * Difficulty: Medium
 * Tags: Linked List, Design
 * CN URL: https://leetcode.cn/problems/design-linked-list/
 * URL: https://leetcode.com/problems/design-linked-list/
 *
 * Approach & 思路:
 * - 使用 dummy 虚拟头节点简化插入/删除逻辑
 * - 用 addAtIndex实现addAtHead和addAtTail
 * - size 字段记录当前链表长度，方便边界判断
 */

public class LC0707_DesignLinkedList {
    public static class MyLinkedList {
        private class Node {
            int val;
            Node next;
            Node(int val) {
                this.val = val;
            }
        }

        private Node dummy; // 虚拟头节点
        private int size;

        public MyLinkedList() {
            dummy = new Node(0); // 不存值，仅用于简化逻辑
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            Node curr = dummy.next;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;
            Node prev = dummy;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            Node newNode = new Node(val);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            Node prev = dummy;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2); // list: 1 → 2 → 3
        System.out.println(list.get(1)); // Output: 2
        list.deleteAtIndex(1); // list: 1 → 3
        System.out.println(list.get(1)); // Output: 3
    }
}
