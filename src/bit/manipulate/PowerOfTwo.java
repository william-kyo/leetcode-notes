package bit.manipulate;

import org.junit.Assert;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo pot = new PowerOfTwo();
        int n;
        boolean expected, actual;

        n = 0;
        expected = false;
        actual = pot.isPowerOfTwo(n);
        Assert.assertEquals(expected, actual);

        n = 1;
        expected = true;
        actual = pot.isPowerOfTwo(n);
        Assert.assertEquals(expected, actual);

        n = 3;
        expected = false;
        actual = pot.isPowerOfTwo(n);
        Assert.assertEquals(expected, actual);


    }
}
