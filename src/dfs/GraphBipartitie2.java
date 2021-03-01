package dfs;

import org.junit.Assert;

public class GraphBipartitie2 {
    public boolean isBipartite(int[][] graph) {

        return true;
    }

    public static void main(String[] args) {
        int[][] grap;
        boolean expected, actual;
        GraphBipartitie2 graphBipartitie = new GraphBipartitie2();

        expected = true;
        grap = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        actual = graphBipartitie.isBipartite(grap);
        Assert.assertEquals(expected, actual);

        expected = false;
        grap = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        actual = graphBipartitie.isBipartite(grap);
        Assert.assertEquals(expected, actual);

        expected = true;
        grap = new int[][]{{1}, {0, 3}, {3}, {1, 2}};
        actual = graphBipartitie.isBipartite(grap);
        Assert.assertEquals(expected, actual);


    }
}
