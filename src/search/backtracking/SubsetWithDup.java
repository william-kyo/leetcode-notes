package search.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SubsetWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        backtracking(ret, deque, nums, 0);
        return ret;
    }

    private void backtracking(List<List<Integer>> ret, Deque<Integer> deque, int[] nums, int index) {
        List<Integer> list = new ArrayList<>(deque);
        if(!ret.contains(list)) {
            ret.add(list);
        }
        for(int i=index; i<nums.length; i++) {
            deque.offerFirst(nums[i]);
            backtracking(ret, deque, nums, i+1);
            deque.poll();
        }
    }

    public static void main(String[] args) {
        SubsetWithDup subsetWithDup = new SubsetWithDup();
        List<List<Integer>> ret = subsetWithDup.subsetsWithDup(new int[]{1, 2, 2});
    }
}
