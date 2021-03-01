package dp;

/**
 * 算法导论-动态规划-矩阵链-15.2
 *
 * @author Wheeler_Hui
 * @version 1.0
 * @date 2020/11/6 10:38
 */
public class MatrixChain {
    // 保存最佳矩阵计算的方案，当前矩阵序号
    private int[][] s;
    // 保存最佳计算代价
    private int[][] m;

    public MatrixChain(int[] p) {
        matrixChainOrder(p);
    }

    private void matrixChainOrder(int[] p) {
        int n = p.length - 1;
        s = new int[n + 1][n + 1];
        m = new int[n + 1][n + 1];
        // 矩阵链的长度
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                // 末尾
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    /**
     * 打印最佳矩阵计算顺序
     */
    public void printOptimalParent(int i, int j) {
        if (i > j) {
            throw new IllegalArgumentException("矩阵链范围非法，入参需满足 i <= j ");
        }
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParent(i, s[i][j]);
            printOptimalParent(s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public int getMagnitude(int i, int j) {
        if (i > j) {
            throw new IllegalArgumentException("矩阵链范围非法，入参需满足 i <= j ");
        }
        return m[i][j];
    }

    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        MatrixChain matrixChain = new MatrixChain(p);
        int m = matrixChain.getMagnitude(1, 6);
        System.out.println(m);
        matrixChain.printOptimalParent(1, 6);
    }
}
