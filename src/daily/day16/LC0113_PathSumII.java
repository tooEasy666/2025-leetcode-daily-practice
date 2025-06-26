package daily.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 0113 - PathSumII
 * Difficulty: medium
 * Tags: 
 * CN URL: https://leetcode.cn/problems/path-sum-ii
 * URL: https://leetcode.com/problems/path-sum-ii
 *
 * Approach & 思路:
 * - 
 */

public class LC0113_PathSumII {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        path.add(node.val);

        // 如果是叶子节点，且路径和满足要求
        if (node.left == null && node.right == null && target == node.val) {
            res.add(new ArrayList<>(path)); // 一定要复制
        }

        dfs(node.left, target - node.val, path, res);
        dfs(node.right, target - node.val, path, res);

        path.remove(path.size() - 1); // 回溯
    }
}
