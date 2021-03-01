import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        // initial HashMap[] store gap-items
        Map<Integer/*gap*/, Integer/*length*/>[] gapLengths = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            gapLengths[i] = new HashMap<>();
        }
        int ans = 0;
        // each element check previous gap-length
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                // same gap, items++
                int diff = A[i] - A[j];
                int length = gapLengths[j].getOrDefault(diff, 1);
                ans = Math.max(length + 1, ans);
                gapLengths[i].put(diff, length + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestArithmeticSequence las = new LongestArithmeticSequence();
        int[] A = new int[]{3, 6, 9, 12};
        int expected = 4;
        int actual = las.longestArithSeqLength(A);
        Assert.assertEquals(expected, actual);

        A = new int[]{9, 4, 7, 2, 10};
        expected = 3;
        actual = las.longestArithSeqLength(A);
        Assert.assertEquals(expected, actual);

        A = new int[]{20, 1, 15, 3, 10, 5, 8};
        expected = 4;
        actual = las.longestArithSeqLength(A);
        Assert.assertEquals(expected, actual);
    }
}
