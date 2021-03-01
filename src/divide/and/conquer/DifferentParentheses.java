package divide.and.conquer;

import utils.MyArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #241 different ways to add parentheses
 */
public class DifferentParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList<>();
        }

        // 递归出口：连续的数字返回其本身
        int index = 0;
        int number = 0;
        while (index < input.length() && !isOperation(input.charAt(index))) {
            number = number * 10 + input.charAt(index) - '0';
            index++;
        }
        if (index == input.length()) {
            return Arrays.asList(number);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (isOperation(input.charAt(i))) {
                // 按照计算字符分割两部分
                // 计算左边结果
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                // 计算右边结果
                List<Integer> res2 = diffWaysToCompute(input.substring(i + 1));

                // 合成结果
                for (Integer p : res1) {
                    for (Integer q : res2) {
                        result.add(calculate(p, q, input.charAt(i)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    private int calculate(int p, int q, char operation) {
        switch (operation) {
            case '+':
                return p + q;
            case '-':
                return p - q;
            case '*':
                return p * q;
        }
        throw new IllegalArgumentException("operation illegal");
    }

    public static void main(String[] args) {
        DifferentParentheses dp = new DifferentParentheses();
        String input;
        List<Integer> expected, actual;

        input = "2-1-1";
        expected = Arrays.asList(0, 2);
        actual = dp.diffWaysToCompute(input);
        MyArrayUtil.assertArray(expected, actual);

        input = "2*3-4*5";
        expected = Arrays.asList(-34, -14, -10, -10, 10);
        actual = dp.diffWaysToCompute(input);
        MyArrayUtil.assertArray(expected, actual);

    }
}
