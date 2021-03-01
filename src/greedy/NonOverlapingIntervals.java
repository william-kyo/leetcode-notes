package greedy;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapingIntervals {
    static class MyComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        // sort
        Arrays.sort(intervals, new MyComparator());
        // save element count that required the interval rule
        int count = 0;
        // meet interval and last pre[1]>=last[0]
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < pre) {
                count++;
                continue;
            }
            pre = intervals[i][1];
        }
        return count;
    }


    public static void main(String[] args) {
        NonOverlapingIntervals noli = new NonOverlapingIntervals();
        int[][] intervals;
        int expected, actual;

        intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        expected = 1;
        actual = noli.eraseOverlapIntervals(intervals);
        Assert.assertEquals(expected, actual);

        intervals = new int[][]{{1, 2}, {2, 3}};
        expected = 0;
        actual = noli.eraseOverlapIntervals(intervals);
        Assert.assertEquals(expected, actual);

        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        expected = 2;
        actual = noli.eraseOverlapIntervals(intervals);
        Assert.assertEquals(expected, actual);
    }
}
