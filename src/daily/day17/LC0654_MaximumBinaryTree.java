package daily.day17;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 0654 - MaximumBinaryTree
 * Difficulty: medium
 * Tags: 
 * CN URL: https://leetcode.cn/problems/maximum-binary-tree
 * URL: https://leetcode.com/problems/maximum-binary-tree
 *
 * Approach & 思路:
 * 方法一：递归（O(n²)）
 * - 每次找到子数组中的最大值作为当前根节点
 * - 分治构造左右子树
 * - 时间复杂度最坏为 O(n²)，当数组为降序时退化为链
 *
 * 方法二：单调栈（O(n)）
 * - 使用递减单调栈构建结构
 * - 当前元素弹出栈中所有比它小的节点作为左子树
 * - 当前元素成为栈顶元素的右子树
 * - 每个节点只进出栈一次
 */

public class LC0654_MaximumBinaryTree {
    // 方法一：递归解法 O(n²)
    public TreeNode constructMaximumBinaryTree_recursive(int[] nums) {
        return build(nums, 0, nums.length);
    }

    // 构建最大二叉树，闭开区间 [left, right)
    private TreeNode build(int[] nums, int left, int right) {
        if (left >= right) return null;

        // 找到最大值及其索引
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, left, maxIndex);
        root.right = build(nums, maxIndex + 1, right);

        return root;
    }

    // 方法二：单调栈解法 O(n)
    public TreeNode constructMaximumBinaryTree_stack(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        for (int num : nums) {
            TreeNode current = new TreeNode(num);

            // 处理左子树：把所有小于当前值的弹出，作为 current 的左子树
            while (!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();
            }

            // 处理右子树：如果栈不空，当前节点是栈顶的右子树
            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }

            stack.push(current);
        }

        // 栈底就是最终的根节点
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

}
