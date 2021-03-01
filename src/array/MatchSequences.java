package array;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MatchSequences {
    /**
     * Input:
     * S = "abcde"
     * words = ["a", "bb", "acd", "ace"]
     * Output: 3
     */
    public int numMatchingSubseq(String S, String[] words) {
        if (null == S || "".equals(S) || null == words) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // foreach word
        // is word match S count++
        int count = 0;
        for (String word : map.keySet()) {
            if (match(S, word)) {
                count = count + map.get(word);
            }
        }
        return count;
    }

    private boolean match(String S, String word) {
        // foreach word's char
        //      if char at S and current_position > previous_position
        //          true
        if (word.length() > S.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == word.length();
    }

    public static void main(String[] args) {
        MatchSequences ms = new MatchSequences();

        String S = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        int expected = 3;
        int actual = ms.numMatchingSubseq(S, words);
        Assert.assertEquals(expected, actual);

        S = "dsahjpjauf";
        words = new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        expected = 2;
        actual = ms.numMatchingSubseq(S, words);
        Assert.assertEquals(expected, actual);

        S = "vvvvvvvvvvvvvvvvvm";
        words = new String[]{"vm", "vm", "vm", "vm"};
        expected = 4;
        actual = ms.numMatchingSubseq(S, words);
        Assert.assertEquals(expected, actual);

    }
}
