package search.backtracking;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // conner case
        if(nums==null||nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, new boolean[nums.length], list, ret);
        return ret;
    }

    private void backtracking(int[] nums, boolean[] marked, List<Integer> list, List<List<Integer>> ret){
        if(list.size()==nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }
        int last = -11;
        for(int i=0; i<nums.length; i++){
            if(!marked[i] && nums[i]!=last){
                marked[i] = true;
                last = nums[i];
                list.add(nums[i]);
                backtracking(nums, marked, list, ret);
                list.remove(list.size()-1);
                marked[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int nums[];
        int[][] expected;
        List<List<Integer>> actual;
        PermutationsII permutationsII = new PermutationsII();

        nums = new int[]{1, 1, 2};
        expected = new int[][]{{1, 1, 2}, {1, 2, 1}, {2, 1, 1}};
        actual = permutationsII.permuteUnique(nums);
        assertArrays(expected, actual);

        nums = new int[]{1, 2, 3};
        expected = new int[][]{{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
        actual = permutationsII.permuteUnique(nums);
        assertArrays(expected, actual);
    }

    private static void assertArrays(int[][] expected, List<List<Integer>> actual) {
        Assert.assertEquals(expected.length, actual.size());
        for(int i = 0; i< expected.length; i++){
            for(int j = 0; j< expected[i].length; j++){
                Assert.assertTrue(expected[i][j] == actual.get(i).get(j));
            }
        }
    }
}
