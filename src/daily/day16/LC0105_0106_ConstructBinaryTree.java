package daily.day16;

import java.util.HashMap;
import java.util.Map;

public class LC0105_0106_ConstructBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // LC0105: Construct from Preorder + Inorder
    private Map<Integer, Integer> inorderIndexMap105;

    public TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        inorderIndexMap105 = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap105.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildPreIn(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIdx = inorderIndexMap105.get(rootVal);
        int leftSize = inRootIdx - inStart;

        root.left = buildPreIn(preorder, preStart + 1, preStart + leftSize, inStart, inRootIdx - 1);
        root.right = buildPreIn(preorder, preStart + leftSize + 1, preEnd, inRootIdx + 1, inEnd);

        return root;
    }

    // LC0106: Construct from Inorder + Postorder
    private Map<Integer, Integer> inorderIndexMap106;

    public TreeNode buildTreeFromInPost(int[] inorder, int[] postorder) {
        inorderIndexMap106 = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap106.put(inorder[i], i);
        }
        return buildInPost(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildInPost(int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIdx = inorderIndexMap106.get(rootVal);
        int rightSize = inEnd - inRootIdx;

        root.left = buildInPost(postorder, postStart, postEnd - rightSize - 1, inStart, inRootIdx - 1);
        root.right = buildInPost(postorder, postEnd - rightSize, postEnd - 1, inRootIdx + 1, inEnd);

        return root;
    }
}