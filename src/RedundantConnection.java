import org.junit.Assert;

/**
 * @see search.dfs.RedundantConnection
 */
public class RedundantConnection {
    private int[] id;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        id = new int[n+1];
        for(int i=1; i<=n; i++){
            id[i] = -i;
        }

        int[] ret = null;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int uId = find(u);
            int vId = find(v);
            if (uId == vId) {
                ret = edge;
                break;
            }
            id[vId] = uId;
        }
        return ret;
    }

    private int find(int x){
        while (id[x] > 0) {
            x = id[x];
        }
        return x;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        RedundantConnection rc = new RedundantConnection();
        int[] expected = new int[]{1, 4};
        int[] actual = rc.findRedundantConnection(edges);
        Assert.assertArrayEquals(expected, actual);
    }
}
