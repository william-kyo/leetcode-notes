package string;

import org.junit.Assert;

public class RemoveRepetitions {
    public static String transform(String input) {
        if (null == input) {
            return null;
        }
        char[] chars = input.toCharArray();
        char prev = chars[0];
        StringBuilder sb = new StringBuilder().append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (prev == chars[i]) {
                continue;
            }
            prev = chars[i];
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "abbcbbb";
        String expected = "abcb";

        String actual = transform(input);
        Assert.assertEquals(expected, actual);
    }
}