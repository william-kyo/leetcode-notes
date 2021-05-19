package search.backtracking;

import utils.MyArrayUtil;

import java.util.*;

public class LetterCombinations {
    static Map<Character, List<Character>> map = new HashMap<>();
    static{
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

    }
    public List<String> letterCombinations(String digits) {
        if (null == digits || digits == "") {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            result = merge(result, c);
        }
        return result;
    }

    private List<String> merge(List<String> result, char c) {
        List<Character> characters = map.get(c);
        if (characters == null) {
            return result;
        }
        if (result.size() == 0) {
            for (Character character : characters) {
                result.add(String.valueOf(character));
            }
            return result;
        }
        List<String> temp = new ArrayList<>();
        for (String str : result) {
            for (Character character : characters) {
                temp.add(str.concat(String.valueOf(character)));
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        String digits;
        List<String> expected, actual;

        digits = "23";
        expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        actual = lc.letterCombinations(digits);
        MyArrayUtil.assertArray(expected, actual);

    }
}
