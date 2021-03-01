package greedy;

import com.sun.jmx.snmp.BerEncoder;
import org.junit.Assert;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // initial p = 0
        // foreach element of nums
        // if p >= length-1 return true
        // else if p=p+num[i]
        // else nums[p] == 0 return false
        if (null == nums) {
            return false;
        }
        int n = nums.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (i <= p) {
                p = Math.max(p, i + nums[i]);
                if (p >= n - 1) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums;
        boolean expected, actual;

        nums = new int[]{2, 3, 1, 1, 4};
        expected = true;
        actual = jumpGame.canJump(nums);
        Assert.assertEquals(expected, actual);

        nums = new int[]{3, 2, 1, 0, 4};
        expected = false;
        actual = jumpGame.canJump(nums);
        Assert.assertEquals(expected, actual);

        nums = new int[]{2, 5, 0, 0};
        expected = true;
        actual = jumpGame.canJump(nums);
        Assert.assertEquals(expected, actual);
    }
}
