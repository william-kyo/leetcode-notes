package dp;

import org.junit.Assert;

public class RobbeHouse {
    public int rob(int[] nums) {
        // initial DP
        int[] DP = new int[nums.length];
        if (nums.length > 0) {
            DP[0] = nums[0];
        }
        if (nums.length > 1) {
            DP[1] = Math.max(DP[0], nums[1]);
        }
        // for each num -> dp[i] = max(dp[i-1], nums[i]+dp[i-2])
        for (int i = 2; i < nums.length; ++i) {
            DP[i] = Math.max(DP[i - 1], nums[i] + DP[i - 2]);
        }
        return DP[nums.length - 1];
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
