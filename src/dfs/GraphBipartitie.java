package dfs;

import org.junit.Assert;

import java.util.Stack;

public class GraphBipartitie {
    public boolean isBipartite(int[][] graph) {
        // 所有的顶点默认未标记为0
        int length = graph.length;
        int[] color = new int[length];

        // 遍历所有的edge
        for (int i = 0; i < length; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            // 如果当前顶点未标记，标记为0
            if (0 == color[i]) {
                color[i] = 1;
            }

            while (!stack.isEmpty()) {
                Integer node = stack.pop();

                // 遍历他的连接点
                for (int v : graph[node]) {
                    // 判断是否标记 未标记记为另外一个颜色
                    if (0 == color[v]) {
                        stack.push(v);
                        color[v] = -color[node];
                    }
                    // 如果已经标记并且和当前的顶点是同一个颜色则返回false
                    if (color[node] == color[v]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] grap;
        boolean expected, actual;
        GraphBipartitie graphBipartitie = new GraphBipartitie();

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
