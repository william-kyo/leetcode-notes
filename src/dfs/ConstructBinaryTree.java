package dfs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    private Map<Integer/*ele*/,Integer/*index*/> inorderMap;
    private int pre_index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left == right) {
            return null;
        }
        TreeNode node = null;
        // 中部当前节点
        int val = preorder[pre_index];
        node = new TreeNode(val);
        int mid = inorderMap.get(val);
        pre_index++;
        // 构建左边节点
        node.left = helper(preorder, left, mid);
        // 构建右边节点
        node.right = helper(preorder, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        TreeNode treeNode = new ConstructBinaryTree().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */