package search.backtrack;

import org.junit.Assert;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        backtracking(nums, set, list, ret);
        return ret;
    }

    private void backtracking(int[] nums, Set<Integer> set, List<Integer> list, List<List<Integer>> ret) {
        // goal:
        if (list.size() >= nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // constraint: can't duplicate in a list
            if (nums[i] < -10) {
                continue;
            }
            if (!set.contains(nums[i])) {
                // choice: pick current number
                set.add(nums[i]);
                list.add(nums[i]);
                int[] newNums = Arrays.copyOf(nums, nums.length);
                newNums[i] = -11;
                backtracking(newNums, set, list, ret);
                set.remove(nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1, 2, 3};
        Integer[][] expected = new Integer[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
        List<List<Integer>> actual = permutations.permute(nums);
        Assert.assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], actual.get(i).toArray(new Integer[0]));
        }
    }
}
