package daily.day16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 0513 - FindBottomLeftTreeValue
 * Difficulty: medium
 * Tags: 
 * CN URL: https://leetcode.cn/problems/find-bottom-left-tree-value
 * URL: https://leetcode.com/problems/find-bottom-left-tree-value
 *
 * Approach & 思路:
 * - 
 */

public class LC0513_FindBottomLeftTreeValue {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // BFS
    public int findBottomLeftValue_BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = root.val;

        while (!queue.isEmpty()) {
            int size = queue.size();
            result = queue.peek().val; // 当前层第一个节点就是最左边

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }

    // DFS
    private int maxDepth = -1;
    private int bottomLeftValue = 0;

    public int findBottomLeftValue_DFS(TreeNode root) {
        dfs(root, 0);
        return bottomLeftValue;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // 第一次到达该深度的最左节点
        if (depth > maxDepth) {
            maxDepth = depth;
            bottomLeftValue = node.val;
        }

        dfs(node.left, depth + 1);  // 先递归左子树，确保左边优先
        dfs(node.right, depth + 1);
    }
}
