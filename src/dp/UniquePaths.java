package dp;

import org.junit.Assert;

public class UniquePaths {
//    public int uniquePaths(int m, int n) {
//        if (m == 1 || n == 1) {
//            return 1;
//        }
//        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
//    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int m, n;
        int expected, actual;
        m = 3;
        n = 2;
        expected = 3;
        actual = up.uniquePaths(m, n);
        Assert.assertEquals(expected, actual);


        m = 7;
        n = 3;
        expected = 28;
        actual = up.uniquePaths(m, n);
        Assert.assertEquals(expected, actual);

    }
}
