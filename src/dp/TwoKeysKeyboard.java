package dp;

import org.junit.Assert;

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TwoKeysKeyboard keyboard = new TwoKeysKeyboard();
        int n, acutal, expecte;

        n = 1;
        expecte = 0;
        acutal = keyboard.minSteps(n);
        Assert.assertEquals(expecte, acutal);

        n = 3;
        expecte = 3;
        acutal = keyboard.minSteps(n);
        Assert.assertEquals(expecte, acutal);

        n = 6;
        expecte = 5;
        acutal = keyboard.minSteps(n);
        Assert.assertEquals(expecte, acutal);
    }
}
