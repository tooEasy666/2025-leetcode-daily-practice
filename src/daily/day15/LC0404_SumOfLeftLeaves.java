package daily.day15;

/**
 * LeetCode 0404 - SumOfLeftLeaves
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/sum-of-left-leaves
 * URL: https://leetcode.com/problems/sum-of-left-leaves
 *
 * Approach & 思路:
 * - 遍历每个节点, 如果它的左孩子是叶子节点，就把它的值加到答案里；否则继续递归左右子树。
 */

public class LC0404_SumOfLeftLeaves {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;

        if (root.left != null) {
            // 判断左孩子是否是叶子节点
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left); // 继续递归左子树
            }
        }

        sum += sumOfLeftLeaves(root.right); // 右子树也要递归
        return sum;
    }
}
