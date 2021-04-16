package array;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        int count = k;
        for(int i=0, l=1, r=n; l<=r; i++){
            if (count > 1) {
                if (count % 2 != 0) {
                    ret[i] = l++;
                } else {
                    ret[i] = r--;
                }
                count--;
            } else {
                ret[i] = l++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        BeautifulArrangementII baII = new BeautifulArrangementII();

        int n = 3;
        int k = 2;
        int[] actual = baII.constructArray(n, k);
        assertLegal(actual, k);

        n = 3;
        k = 1;
        actual = baII.constructArray(n, k);
        assertLegal(actual, k);

        n = 9;
        k = 8;
        actual = baII.constructArray(n, k);
        assertLegal(actual, k);

        n = 5;
        k = 2;
        actual = baII.constructArray(n, k);
        assertLegal(actual, k);

        n = 9;
        k = 5;
        actual = baII.constructArray(n, k);
        assertLegal(actual, k);
    }

    private static void assertLegal(int[] actual, int k){
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < actual.length; i++) {
            set.add(Math.abs(actual[i] - actual[i - 1]));
        }
        Assert.assertEquals(k, set.size());

    }
}
