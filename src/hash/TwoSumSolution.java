package hash;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> keyIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int aim = target - nums[i];
            if ( keyIndex.containsKey(aim)) {
                return new int[]{keyIndex.get(aim), i};
            }
            keyIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution for two sum");
    }

    public static void main(String[] args) {
        /**
         * Given nums = [2, 7, 11, 15], target = 9,
         *
         * Because nums[0] + nums[1] = 2 + 7 = 9,
         * return [0, 1].
         */
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSumSolution solution = new TwoSumSolution();
        int[] actual = solution.twoSum(nums, target);
        int[] expected = {0, 1};
        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] actual2 = solution.twoSum(nums2, target2);
        int[] expected2 = {1, 2};
        Assert.assertEquals(expected2[0], actual2[0]);
        Assert.assertEquals(expected2[1], actual2[1]);

        int[] nums3 = {0, 4, 3, 0};
        int target3 = 0;
        int[] actual3 = solution.twoSum(nums3, target3);
        int[] expected3 = {0, 3};
        Assert.assertEquals(expected3[0], actual3[0]);
        Assert.assertEquals(expected3[1], actual3[1]);
    }
}
