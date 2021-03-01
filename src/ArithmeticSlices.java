import org.junit.Assert;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        // for 3 -> N as length
        for (int i = 3; i <= A.length; i++) {
            //      for i -> A.length
            for (int j = i - 1; j < A.length; j++) {
                //          if arr i-length+1, i is sequence
                //              accumulate count
                if (isSequence(A, j - i + 1, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isSequence(int[] A, int l, int r) {
        int diff = A[l + 1] - A[l];
        for (int i = l; i < r; i++) {
            if (A[i + 1] - A[i] != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        ArithmeticSlices as = new ArithmeticSlices();
        int actual = as.numberOfArithmeticSlices(A);
        int expected = 3;
        Assert.assertEquals(expected, actual);

        A = new int[]{1, 1, 2, 5, 7};
        actual = as.numberOfArithmeticSlices(A);
        expected = 0;
        Assert.assertEquals(expected, actual);

        A = new int[]{1, 3, 5, 7, 9};
        actual = as.numberOfArithmeticSlices(A);
        expected = 6;
        Assert.assertEquals(expected, actual);

        A = new int[]{7, 7, 7, 7};
        actual = as.numberOfArithmeticSlices(A);
        expected = 3;
        Assert.assertEquals(expected, actual);

        A = new int[]{3, -1, -5, -9};
        actual = as.numberOfArithmeticSlices(A);
        expected = 3;
        Assert.assertEquals(expected, actual);


    }
}
