package unionfind;

import org.junit.Assert;

public class NumberOfIslands {
    private final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        // conner case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            int cur = i * col + j;
                            int dir = x * col + y;
                            unionFind.union(cur, dir);
                        }
                    }
                }
            }
        }

        return unionFind.count;
    }

    private static class UnionFind {
        int[] parent;
        int count = 0;

        private UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            parent = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * col + j;
                        parent[id] = id;
                        count++;
                    }
                }
            }
        }

        private void union(int x, int y) {
            int idX = father(x);
            int idY = father(y);
            if (idX != idY) {
                parent[idY] = x;
                count--;
            }
        }

        private int father(int x) {
            if (x == parent[x]) {
                return x;
            }
            x = parent[x];
            return father(x);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '1'}};
        int expected = 2;
        int actual = noi.numIslands(grid);
        Assert.assertEquals(expected, actual);

        grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        expected = 3;
        actual = noi.numIslands(grid);
        Assert.assertEquals(expected, actual);

        grid = new char[][]{{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};
        expected = 1;
        actual = noi.numIslands(grid);
        Assert.assertEquals(expected, actual);

    }
}
