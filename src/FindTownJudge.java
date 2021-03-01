import org.junit.Assert;

public class FindTownJudge {
    public int findJudge(int N, int[][] trust) {
        boolean[] trusted = new boolean[N + 1];
        int[] beTrusted = new int[N + 1];

        int a, b;
        for (int[] t : trust) {
            a = t[0];
            b = t[1];
            trusted[a] = true;
            beTrusted[b]++;
        }

        // judge trusted is false && beTrusted with others
        for (int i = 1; i <= N; i++) {
            if (!trusted[i] && beTrusted[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N, expected, actual;
        int[][] trust;
        FindTownJudge findTownJudge = new FindTownJudge();

        N = 2;
        trust = new int[][]{{1, 2}};
        expected = 2;
        actual = findTownJudge.findJudge(N, trust);
        Assert.assertEquals(expected, actual);

        N = 3;
        trust = new int[][]{{1, 3}, {2, 3}};
        expected = 3;
        actual = findTownJudge.findJudge(N, trust);
        Assert.assertEquals(expected, actual);

        N = 3;
        trust = new int[][]{{1, 2}, {2, 3}, {3, 1}};
        expected = -1;
        actual = findTownJudge.findJudge(N, trust);
        Assert.assertEquals(expected, actual);

        N = 3;
        trust = new int[][]{{1, 2}, {2, 3}};
        expected = -1;
        actual = findTownJudge.findJudge(N, trust);
        Assert.assertEquals(expected, actual);

        N = 4;
        trust = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        expected = 3;
        actual = findTownJudge.findJudge(N, trust);
        Assert.assertEquals(expected, actual);
    }
}
