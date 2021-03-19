package search.dfs;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;


public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] edgeTo = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            edgeTo[i] = new LinkedList<>();
        }

        // check cycle
        int[] ret = null;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dfs(edgeTo, u, v, 0)) {
                ret = edge;
            } else {
                edgeTo[u].add(v);
                edgeTo[v].add(u);
            }
        }
        return ret;
    }

    /**
     * 判断 u->v是否可达
     * @param edgeTo 已经遍历的边集合
     * @param u from
     * @param v to
     * @param pre 当前正在校验的节点，避免死循环
     * @return true or false
     */
    private boolean dfs(List<Integer>[] edgeTo, int u, int v, int pre) {
        if (u == v) {
            return true;
        }
        for (int w : edgeTo[u]) {
            if (w == pre) {
                continue;
            }
            if (dfs(edgeTo, w, v, u)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        RedundantConnection rc = new RedundantConnection();
        int[] expected = new int[]{1, 4};
        int[] actual = rc.findRedundantConnection(edges);
        Assert.assertArrayEquals(expected, actual);
    }
}
