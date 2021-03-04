package array;

import org.junit.Assert;

import java.util.PriorityQueue;

public class KthSmallestElement {
    // 方式一：使用堆排序
    /*
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x1, x2) -> x2.compareTo(x1));
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
            }
        }

        for (int i = 0; i < n * n - k; i++) {
            pq.poll();
        }
        return pq.peek();
    }
    */

    // 方式二： 使用二分查找 Time Complexity O(n*m*log(n+m))
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[m - 1][n - 1];

        while (lo < hi) {
            int count = 0;
            int mid = lo + (hi - lo) / 2;

            // 统计当前有多少个数比mid小
            for (int i = 0; i < m; i++) {
                int j = n - 1;
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j + 1;
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        KthSmallestElement kse = new KthSmallestElement();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        int expected = 13;
        int actual = kse.kthSmallest(matrix, k);
        Assert.assertEquals(expected, actual);

        int[][] matrix2 = {{-5}};
        k = 1;
        expected = -5;
        actual = kse.kthSmallest(matrix2, k);
        Assert.assertEquals(expected, actual);

    }
}
