package daily.day17;

/**
 * LeetCode 0700 - SearchBST
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/search-in-a-binary-search-tree
 * URL: https://leetcode.com/problems/search-in-a-binary-search-tree
 *
 * Approach & 思路:
 * -
 */

public class LC0700_SearchBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) return searchBST(root.left, val);
        if (val > root.val) return searchBST(root.right, val);
        return root;
    }
}

