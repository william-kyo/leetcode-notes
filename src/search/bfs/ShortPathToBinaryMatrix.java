package search.bfs;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class ShortPathToBinaryMatrix {
    private int[][] direction = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] validated = new boolean[n][n];

        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 0) {
            queue.add(new int[]{0, 0});
            validated[0][0] = true;
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] node = queue.remove();
                int i = node[0];
                int j = node[1];
                if (i == n - 1 && j == n - 1) {
                    return step + 1;
                }
                for (int k = 0; k < 8; k++) {
                    int nextRow = i + direction[k][0];
                    int nextCol = j + direction[k][1];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !validated[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
                        queue.add(new int[]{nextRow, nextCol});
                        validated[nextRow][nextCol] = true;
                    }
                }
            }
            step++;

        }
        return -1;
    }

    public static void main(String[] args) {
        ShortPathToBinaryMatrix spm = new ShortPathToBinaryMatrix();
        int[][] grid = new int[][]{{0, 1}, {1, 0}};
        int expected = 2;
        int actual = spm.shortestPathBinaryMatrix(grid);
        Assert.assertEquals(expected, actual);
    }
}
