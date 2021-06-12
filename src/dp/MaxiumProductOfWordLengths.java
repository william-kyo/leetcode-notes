package dp;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class MaxiumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int[][] dp = new int[words.length][words.length];
        Set<Character>[] sets = new Set[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                if (sets[j] == null) {
                    sets[j] = new HashSet<>();
                    for (char c : words[j].toCharArray()) {
                        sets[j].add(c);
                    }
                }
                int current = 0;
                if (!hasCommonLetters(words[i], sets[j])) {
                    current = words[i].length() * words[j].length();
                }
                dp[i][j] = Math.max(current, dp[i][j]);
            }
        }

        return dp[words.length - 1][words.length - 1];
    }

    private boolean hasCommonLetters(String str, Set<Character> sets) {
        for (char c : str.toCharArray()) {
            if (sets.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MaxiumProductOfWordLengths maxiumP = new MaxiumProductOfWordLengths();
        String[] words;
        int expected, actual;

        words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        expected = 16;
        actual = maxiumP.maxProduct(words);
        Assert.assertEquals(expected, actual);
    }
}
