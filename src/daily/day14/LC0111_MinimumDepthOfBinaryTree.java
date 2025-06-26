package daily.day14;

public class LC0111_MinimumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // 如果只有左子树为空，那就只能走右子树，右不为空，这时并不是最低点
        if (root.left == null) return 1 + minDepth(root.right);

        // 如果只有右子树为空，那就只能走左子树，左不为空，这时并不是最低点
        if (root.right == null) return 1 + minDepth(root.left);

        // 如果左右子树都不为空，取最小值
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
