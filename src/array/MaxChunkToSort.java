package array;

import org.junit.Assert;

public class MaxChunkToSort {
    public int maxChunksToSorted(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxChunkToSort maxChunk = new MaxChunkToSort();
        int[] arr;
        int expected, actual;

        arr = new int[]{4, 3, 2, 1, 0};
        expected = 1;
        actual = maxChunk.maxChunksToSorted(arr);
        Assert.assertEquals(expected, actual);

        arr = new int[]{1, 0, 2, 3, 4};
        expected = 4;
        actual = maxChunk.maxChunksToSorted(arr);
        Assert.assertEquals(expected, actual);


    }
}
