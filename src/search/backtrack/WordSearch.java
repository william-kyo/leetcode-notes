package search.backtrack;

import org.junit.Assert;

public class WordSearch {
    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0 || word == null) {
            return false;
        }
        // find positions of the board for the word's first letter
        int m = board.length;
        int n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                marked[i][j] = true;
                if (backtracking(board, marked, i, j, word, 0)) {
                    return true;
                }
                marked[i][j] = false;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, boolean[][] marked, int r, int c, String word, int p) {

        if (board[r][c] == word.charAt(p)) {
            // goal: find the last letter of word
            if (p == word.length() - 1) {
                return true;
            }

            for (int[] d : directions) {
                int x = r + d[0];
                int y = c + d[1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !marked[x][y]) {
                    marked[x][y] = true;
                    if (backtracking(board, marked, x, y, word, p + 1)) {
                        return true;
                    }
                    marked[x][y] = false;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board;
        String word;
        boolean expected, actual;

        board = new char[][]{{'A', 'B', 'C', 'F'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'F'}};
        word = "ABCEFSADEFSE";
        expected = false;
        actual = wordSearch.exist(board, word);
        Assert.assertEquals(expected, actual);

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'F'}};
        word = "ABCEFSADEFSE";
        expected = true;
        actual = wordSearch.exist(board, word);
        Assert.assertEquals(expected, actual);

        board = new char[][]{{'A'}};
        word = "A";
        expected = true;
        actual = wordSearch.exist(board, word);
        Assert.assertEquals(expected, actual);

        board = new char[][]{{'A'},{'A'}};
        word = "AAA";
        expected = false;
        actual = wordSearch.exist(board, word);
        Assert.assertEquals(expected, actual);


    }
}
