package search.dfs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree2 {
    private int pre_index = 0;
    private int[] inorder;
    private int[] postorder;
    private Map<Integer/*element*/, Integer/*Index*/> map;//保存中序遍历元素和位置

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pre_index = postorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, postorder.length);
    }

    private TreeNode helper(int left, int right) {
        if (left == right) {
            return null;
        }
        TreeNode node = null;
        // 构建当前节点
        node = new TreeNode(postorder[pre_index]);
        int mid = map.get(postorder[pre_index]);//中序遍历分割左边和右边
        pre_index--;//定位后序遍历
        // 递归构建右边子节点
        node.right = helper(mid + 1, right);
        // 递归构建左边子节点
        node.left = helper(left, mid);
        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTree2 constructBinaryTree2 = new ConstructBinaryTree2();

        int[] inorder = null;
        int[] postorder = null;
        TreeNode actual = null;

        inorder = new int[]{9,3,15,20,7};
        postorder = new int[]{9,15,7,20,3};
        actual = constructBinaryTree2.buildTree(inorder, postorder);

        System.out.println(actual);

    }
}
