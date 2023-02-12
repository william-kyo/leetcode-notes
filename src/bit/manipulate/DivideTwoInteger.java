package bit.manipulate;

import org.junit.Assert;

public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        long quotient = 0;
        long remain = Math.abs(dividend);
        if (Integer.compare(dividend, Integer.MIN_VALUE) == 0) {
            remain = Integer.MAX_VALUE;
        }
        while(remain>=Math.abs(divisor)) {
            remain = remain - Math.abs(divisor);
            quotient++;
        }
        if((dividend<0 && divisor>0) || (dividend > 0 && divisor < 0)) {
            return (int)-quotient;
        }
        return (int)quotient;
    }

    public static void main(String[] args) {
        DivideTwoInteger main = new DivideTwoInteger();
        int dividend, divisor;
        int expected, actual;

        dividend = -2147483648;
        divisor = -1;
        expected = 2147483647;
        actual = main.divide(dividend, divisor);
        Assert.assertEquals(expected, actual);

    }
}
