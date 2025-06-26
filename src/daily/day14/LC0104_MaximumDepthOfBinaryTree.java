package daily.day14;

public class LC0104_MaximumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        // dfs
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
