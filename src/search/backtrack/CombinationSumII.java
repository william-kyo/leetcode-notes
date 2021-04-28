package search.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(candidates, 0, target, list, ret);
        // remove duplicate list
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> l : ret) {
            List<Integer> newList = l.stream().sorted().collect(Collectors.toList());
            if (!result.contains(newList)) {
                result.add(newList);
            }
        }
        return result;
    }

    private void backtracking(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> ret) {
        // goal: find list numbers sum to target
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // constraint: list numbers sum less than or equal to target
            // choice: pick current number
            list.add(candidates[i]);
            backtracking(candidates, i + 1, target - candidates[i], list, ret);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = new int[]{8, 10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> actual = combinationSumII.combinationSum2(candidates, target);
        System.out.println(actual.size());

    }
}
