package daily.day15;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 0257 - BinaryTreePaths
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/binary-tree-paths
 * URL: https://leetcode.com/problems/binary-tree-paths
 *
 * Approach & 思路:
 * -
 */

public class LC0257_BinaryTreePaths {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> res) {
        int len = path.length();
        path.append(node.val);

        if (node.left == null && node.right == null) {
            res.add(path.toString());
        } else {
            path.append("->");
            if (node.left != null) dfs(node.left, path, res);
            if (node.right != null) dfs(node.right, path, res);
        }

        // 回溯，恢复 path 长度
        path.setLength(len);
    }
}

