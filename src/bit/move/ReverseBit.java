package bit.move;

import org.junit.Assert;

public class ReverseBit {
    public int reverseBits(int n) {
        int ret = 0;
        int p = 31;
        while (p >= 0) {
            int current = n & 1;
            ret += current << p;
            n = n >>> 1;
            p--;
        }
        return ret;
    }

    public static void main(String[] args) {
        ReverseBit reverseBit = new ReverseBit();
        int n, expected, actual;
        n = 13;
        expected = -1342177280;
        actual = reverseBit.reverseBits(n);
        Assert.assertEquals(expected, actual);

    }
}
