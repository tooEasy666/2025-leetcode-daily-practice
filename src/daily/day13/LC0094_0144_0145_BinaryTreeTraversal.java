package daily.day13;

import java.util.ArrayList;
import java.util.List;

public class LC0094_0144_0145_BinaryTreeTraversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // 前序遍历·递归·LC144_二叉树的前序遍历
    static class Solution_0144 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            preorder(root, result);
            return result;
        }

        public void preorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }
    // 中序遍历·递归·LC94_二叉树的中序遍历
    static class Solution_0094 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
    // 后序遍历·递归·LC145_二叉树的后序遍历
    static class Solution_0145 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postorder(root, res);
            return res;
        }

        void postorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
    }
}
