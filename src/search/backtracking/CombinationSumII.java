package search.backtracking;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(candidates, 0, target, list, ret);
        return ret;
    }

    private void backtracking(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> ret) {
        // goal: find list numbers sum to target
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        // constraint 1: list numbers sum less than or equal to target
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // constraint 2: duplicate : list[], 1,1,2,3
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // choice: pick current number
            list.add(candidates[i]);
            backtracking(candidates, i + 1, target - candidates[i], list, ret);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = new int[]{8, 10, 1, 2, 7, 6, 1, 5};
        Integer target = 8;
        List<List<Integer>> actual = combinationSumII.combinationSum2(candidates, target);
        for (List<Integer> l : actual) {
            Assert.assertEquals(target, l.stream().reduce(0, Integer::sum));
        }

        candidates = new int[]{8, 10, 1, 1, 2, 7, 6, 1, 5};
        target = 8;
        actual = combinationSumII.combinationSum2(candidates, target);
        for (List<Integer> l : actual) {
            Assert.assertEquals(target, l.stream().reduce(0, Integer::sum));
        }
    }
}
