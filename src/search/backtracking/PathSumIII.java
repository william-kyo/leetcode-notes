package search.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PathSumIII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root==null) {
            return ret;
        }
        list.add(root.val);
        backtracking(ret, list, root, targetSum);
        return ret;
    }

    private void backtracking(List<List<Integer>> ret, List<Integer> list, TreeNode node, int targetSum) {
        int listSum = list.stream().mapToInt(Integer::intValue).sum();
        if (node.left == null && node.right == null && listSum == targetSum) {
            ret.add(new ArrayList<>(list));
            return;
        }

        if(node.left!=null) {
            list.add(node.left.val);
            backtracking(ret, list, node.left, targetSum);
            list.remove(list.size()-1);
        }
        if(node.right!=null) {
            list.add(node.right.val);
            backtracking(ret, list, node.right, targetSum);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSumIII solution = new PathSumIII();
        List<List<Integer>> result = solution.pathSum(root, 22);

        // expected output: [[5, 4, 11, 2], [5, 8, 4, 5]]
        assertEquals(2, result.size());
        assertEquals(Arrays.asList(5, 4, 11, 2), result.get(0));
        assertEquals(Arrays.asList(5, 8, 4, 5), result.get(1));
    }
}
