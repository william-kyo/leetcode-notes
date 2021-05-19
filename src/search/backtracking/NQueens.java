package search.backtracking;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] table = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(table[i], '.');
        }

        List<List<String>> ret = new ArrayList<>();
        backtracking(ret, table, 0);
        return ret;
    }

    private void backtracking(List<List<String>> ret, char[][] table, int col) {
        // goal: find all possible position
        if (col >= table.length) {
            ret.add(construct(table));
            return;
        }
        for (int i = 0; i < table.length; i++) {
            if (validate(table, i, col)) {
                // choice: find each possible Queen position
                table[i][col] = 'Q';
                backtracking(ret, table, col + 1);
                table[i][col] = '.';
            }
        }
    }

    private boolean validate(char[][] table, int row, int col) {
        // constraint: the rule of Queen's movement
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < col; j++) {
                if (table[i][j] == 'Q' && (i == row || j == col || (row - col == i - j) || (row + col == i + j))) {
                    return false;
                }
            }
        }
        return true;
    }


    private List<String> construct(char[][] table) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            list.add(new String(table[i]));
        }
        return list;
    }

    public static void main(String[] args) {
        String[][] expected = new String[][]{{"..Q.", "Q...", "...Q", ".Q.."}, {".Q..", "...Q", "Q...", "..Q."}};
        int n = 4;
        NQueens NQ = new NQueens();
        List<List<String>> actual = NQ.solveNQueens(n);
        assertList(expected, actual);

        n = 3;
        expected = new String[][]{};
        actual = NQ.solveNQueens(n);
        assertList(expected, actual);

        n = 1;
        expected = new String[][]{{"Q"}};
        actual = NQ.solveNQueens(n);
        assertList(expected, actual);
    }

    private static void assertList(String[][] expected, List<List<String>> actual) {
        Assert.assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i].length, actual.get(i).size());
            for (int j = 0; j < expected[i].length; j++) {
                Assert.assertEquals(expected[i][j], actual.get(i).get(j));
            }

        }
    }
}
