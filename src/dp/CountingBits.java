package dp;

import utils.MyArrayUtil;

public class CountingBits {
//    public int[] countBits(int num) {
//        int[] ans = new int[num + 1];
//        for (int i = 0; i <= num; ++i)
//            ans[i] = popcount(i);
//        return ans;
//    }
//    private int popcount(int x) {
//        int count;
//        for (count = 0; x != 0; ++count)
//            x &= x - 1; //zeroing out the least significant nonzero bit
//        return count;
//    }

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                // 偶数i i*2 的二进制数中1的位数相同（二进制左移1位，右边补0，1的个数不变）
                dp[i] = dp[i / 2];
            } else {
                // 奇数i 为前一位在末尾加1
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int num;
        int[] expected, actual;

        num = 0;
        expected = new int[]{0};
        actual = countingBits.countBits(num);
        MyArrayUtil.assertArray(expected, actual);

        num = 1;
        expected = new int[]{0,1};
        actual = countingBits.countBits(num);
        MyArrayUtil.assertArray(expected, actual);

        num = 2;
        expected = new int[]{0,1,1};
        actual = countingBits.countBits(num);
        MyArrayUtil.assertArray(expected, actual);

    }
}
