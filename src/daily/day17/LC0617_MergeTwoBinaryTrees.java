package daily.day17;

/**
 * LeetCode 0617 - MergeTwoBinaryTrees
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/merge-two-binary-trees
 * URL: https://leetcode.com/problems/merge-two-binary-trees
 *
 * Approach & 思路:
 * -
 */

public class LC0617_MergeTwoBinaryTrees {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}
