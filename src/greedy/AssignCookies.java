package greedy;

import org.junit.Assert;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int q = 0;
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = q; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    q = j + 1;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] g, s;
        int actual, expected;

        g = new int[]{1, 2, 3};
        s = new int[]{1, 1};
        expected = 1;
        actual = assignCookies.findContentChildren(g, s);
        Assert.assertEquals(expected, actual);

        g = new int[]{1, 2};
        s = new int[]{1, 2, 3};
        expected = 2;
        actual = assignCookies.findContentChildren(g, s);
        Assert.assertEquals(expected, actual);

        g = new int[]{10, 9, 8, 7};
        s = new int[]{5, 6, 7, 8};
        expected = 2;
        actual = assignCookies.findContentChildren(g, s);
        Assert.assertEquals(expected, actual);

    }
}
