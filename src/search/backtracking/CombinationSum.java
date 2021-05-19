package search.backtracking;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        backtracking(candidates, target, 0, list, ret);
        return ret;
    }

    private void backtracking(int[] candidates, int target, int p, List<Integer> list, List<List<Integer>> ret){
        if(target==0){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i=p; i<candidates.length; i++){
            if(target>=candidates[i]){
                list.add(candidates[i]);
                backtracking(candidates, target-candidates[i], i, list, ret);
                list.remove(list.size()-1);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = new int[]{2, 7, 6, 3, 5, 1};
        Integer target = 9;
        List<List<Integer>> acutal = cs.combinationSum(candidates, target);
        for (List<Integer> list : acutal) {
            Optional<Integer> sum = list.stream().reduce(Integer::sum);
            Assert.assertEquals(target, sum.get());
        }


    }
}
