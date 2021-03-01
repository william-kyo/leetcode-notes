package array;

import org.junit.Assert;

import java.util.TreeMap;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // counting arr1's element
        int[] cnt = new int[1001];
        TreeMap<Integer, Integer> countsMap = new TreeMap<>();
        for (int i : arr1) {
            cnt[i]++;
            countsMap.put(i, countsMap.getOrDefault(i, 0) + 1);
        }

        // reform arr1 as arr2's order
        int idx = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0) {
                arr1[idx++] = n;
            }
        }

        // add rest of arr1
        for (int i=0; i < 1000; i++) {
            while (cnt[i]-- > 0) {
                arr1[idx++] = i;
            }
        }
        return arr1;
    }

    /**
     * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * Output: [2,2,2,1,4,3,3,9,6,7,19]
     * @param args
     */
    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        int[] expected = new int[]{2,2,2,1,4,3,3,9,6,7,19};
        int[] actual = relativeSortArray.relativeSortArray(arr1, arr2);

        assertArray(expected, actual);

        arr1 = new int[]{28,6,22,8,44,17};
        arr2 = new int[]{22,28,8,6};
        expected = new int[]{22,28,8,6,17,44};
        actual = relativeSortArray.relativeSortArray(arr1, arr2);
        assertArray(expected, actual);
    }

    private static void assertArray(int[] expected, int[] actual) {
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }
}
