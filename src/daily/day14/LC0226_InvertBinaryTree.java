package daily.day14;

/**
 * URL: https://leetcode.cn/problems/invert-binary-tree/
 *
 * Approach & 思路:
 * -
 */

public class LC0226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 先交换当前节点的左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 再递归处理子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
}
