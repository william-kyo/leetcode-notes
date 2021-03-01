package binary.search;

import org.junit.Assert;

public class Sqrtx {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x can't be less than 0!");
        }
        long left = 0;
        long right = x;
        long mid, square;
        while (left + 1 < right) {
            mid = (left + right) >> 1;
            square = mid * mid;
            if (square == x) {
                return (int)mid;
            } else if (square > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (right * right == x) {
            return (int)right;
        }
        return (int)left;
    }


    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        int x;
        int expected, actual;

        expected = 2;
        x = 4;
        actual = sqrtx.mySqrt(x);
        Assert.assertEquals(expected, actual);

        expected = 2;
        x = 8;
        actual = sqrtx.mySqrt(x);
        Assert.assertEquals(expected, actual);

        expected = 3;
        x = 9;
        actual = sqrtx.mySqrt(x);
        Assert.assertEquals(expected, actual);

        expected = 2;
        x = 6;
        actual = sqrtx.mySqrt(x);
        Assert.assertEquals(expected, actual);


    }
}
