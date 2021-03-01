package dp;

import org.junit.Assert;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int length = n < 4 ? 4 : n + 1;
        // initial solution array
        int[] solution = new int[length];
        solution[1] = 1;
        solution[2] = 2;
        solution[3] = 3;
        // for each element fill solution
        for (int i = 1; i <= n; ++i) {
            if (i > 3) {
                solution[i] = solution[i - 1] + solution[i - 2];
            }
        }

        return solution[n];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int n, expected, actual;

        n = 2;
        expected = 2;
        actual = cs.climbStairs(n);
        Assert.assertEquals(expected, actual);

        n = 3;
        expected = 3;
        actual = cs.climbStairs(n);
        Assert.assertEquals(expected, actual);

        n = 4;
        expected = 5;
        actual = cs.climbStairs(n);
        Assert.assertEquals(expected, actual);


    }
}
