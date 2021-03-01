package greedy;

import org.junit.Assert;

public class RobbeHouse {
    public int rob(int[] nums) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                continue;
            }
            if (i % 2 == 0) {
                even += nums[i];
                even = Math.max(even, odd);
            } else {
                odd += nums[i];
                odd = Math.max(even, odd);
            }
        }

        return Math.max(even, odd);
    }

    public static void main(String[] args) {
        RobbeHouse rh = new RobbeHouse();
        int[] nums;
        int expected, actual;

        nums = new int[]{1, 2, 3, 1};
        expected = 4;
        actual = rh.rob(nums);
        Assert.assertEquals(expected, actual);

        nums = new int[]{2, 7, 9, 3, 1};
        expected = 12;
        actual = rh.rob(nums);
        Assert.assertEquals(expected, actual);

        nums = new int[]{2, 1, 1, 2};
        expected = 4;
        actual = rh.rob(nums);
        Assert.assertEquals(expected, actual);

        nums = new int[]{1, 7, 5, 1, 3};
        expected = 10;
        actual = rh.rob(nums);
        Assert.assertEquals(expected, actual);
    }
}
