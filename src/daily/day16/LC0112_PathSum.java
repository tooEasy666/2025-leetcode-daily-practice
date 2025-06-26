package daily.day16;

/**
 * LeetCode 0112 - PathSum
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/path-sum
 * URL: https://leetcode.com/problems/path-sum
 *
 * Approach & 思路:
 * -
 */

public class LC0112_PathSum {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int newTarget = targetSum - root.val;

        if (root.left == null && root.right == null) {
            return newTarget == 0;
        }

        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
}

