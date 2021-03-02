package array;

import org.junit.Assert;

import java.util.PriorityQueue;

public class KthSmallestElement {
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
