package daily.day17;

/**
 * LeetCode 0098 - ValidateBinarySearchTree
 * Difficulty: medium
 * Tags:
 * CN URL: https://leetcode.cn/problems/validate-binary-search-tree
 * URL: https://leetcode.com/problems/validate-binary-search-tree
 *
 * Approach & 思路:
 * - 对于当前节点，维护一个合法的值范围 [min, max]；
 * 左子树递归时上限变为当前节点值；
 * 右子树递归时下限变为当前节点值；
 * 如果某个节点不在合法范围内，就不是合法 BST。
 */

public class LC0098_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) return true;

        if (node.val <= lower || node.val >= upper) return false;

        return helper(node.left, lower, node.val) &&
                helper(node.right, node.val, upper);
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
}

