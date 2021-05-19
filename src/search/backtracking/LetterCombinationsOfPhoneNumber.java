package search.backtracking;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] buttons = new String[]{null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ret = new ArrayList<>();
        String s = "";
        backtracking(buttons, digits, s, 0, ret);
        return ret;
    }

    private void backtracking(String[] buttons, String digits, String s, int index, List<String> ret) {
        if (index >= digits.length()) {
            ret.add(s);
            return;
        }
        String keys = buttons[calculate(digits.charAt(index))];
        for (int i = 0; i < keys.length(); i++) {
            s = s.concat(keys.substring(i, i + 1));
            backtracking(buttons, digits, s, index + 1, ret);
            s = s.substring(0, index);
        }
    }

    private int calculate(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber lc = new LetterCombinationsOfPhoneNumber();
        String[] expected = new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        String digits = "23";
        List<String> actual = lc.letterCombinations(digits);
        assertList(expected, actual);

    }

    private static void assertList(String[] expected, List<String> actual) {
        int len = expected.length;
        Assert.assertEquals(len, actual.size());
        for (int i = 0; i < len; i++) {
            Assert.assertEquals(expected[i], actual.get(i));
        }
    }
}
