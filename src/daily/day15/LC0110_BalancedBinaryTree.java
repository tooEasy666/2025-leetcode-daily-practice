package daily.day15;

/**
 * LeetCode 0110 - BalancedBinaryTree
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/balanced-binary-tree
 * URL: https://leetcode.com/problems/balanced-binary-tree
 *
 * Approach & 思路:
 * -
 */



public class LC0110_BalancedBinaryTree {
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

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1; // Left subtree is unbalanced
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1; // Left subtree not balanced

        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node not balanced

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

