package daily.day15;

/**
 * LeetCode 0222 - CountCompleteTreeNodes
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/count-complete-tree-nodes
 * URL: https://leetcode.com/problems/count-complete-tree-nodes
 *
 * Approach & 思路:
 * -
 */

public class LC0222_CountCompleteTreeNodes {
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

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        if (left == right) {
            // Tree is a perfect binary tree
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getHeightLeft(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getHeightRight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}

