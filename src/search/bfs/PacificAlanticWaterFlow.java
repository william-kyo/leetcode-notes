package search.bfs;

import org.junit.Assert;

import java.util.*;

public class PacificAlanticWaterFlow {
    int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // marked visited
        boolean[][] pacific = new boolean[m][n];
        boolean[][] alantic = new boolean[m][n];
        // grid flood by ocean
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        // vertical border
        for (int i = 0; i < m; i++) {
            pQueue.add(new int[]{i, 0});
            aQueue.add(new int[]{i, n - 1});
            pacific[i][0] = true;
            alantic[i][n - 1] = true;
        }
        // horizontal border
        for (int i = 0; i < n; i++) {
            pQueue.add(new int[]{0, i});
            aQueue.add(new int[]{m - 1, i});
            pacific[0][i] = true;
            alantic[m - 1][i] = true;
        }
        // marked accessible
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, alantic);
        // filter both accessible
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && alantic[i][j]) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(i);
                    list.add(j);
                    ret.add(list);
                }
            }
        }
        return ret;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] d : direction) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[cur[0]][cur[1]] > matrix[x][y]) {
                    continue;
                }
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
    }

    public static void main(String[] args) {
        PacificAlanticWaterFlow pawf = new PacificAlanticWaterFlow();
        int[][] matrix = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] expected = new int[][]{{0,4},{1,3},{1,4},{2,2},{3,0},{3,1},{4,0}} ;
        List<List<Integer>> actual = pawf.pacificAtlantic(matrix);

        int index = 0;
        for (List<Integer> ac : actual) {
            Assert.assertTrue(ac.get(0).equals(expected[index][0]));
            Assert.assertTrue(ac.get(1).equals(expected[index][1]));
            index++;

        }
    }
}