package search.dfs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
    private List<Integer>[] adj; // v->w, next vertext on the path
    private Stack<Integer> reversePostOrder;
    private boolean[] marked;
    private boolean[] onStack;
    private boolean hasCycle;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new List[numCourses];
        reversePostOrder = new Stack<>();
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];

        // convert to adjacent
        for (int[] edge : prerequisites) {
            int w = edge[0];
            int v = edge[1];
            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(w);
        }
        // topological sort
        for (int v = 0; v < numCourses; v++) {
            if (!marked[v]) {
                dfs(adj, v);
            }
        }

        if(hasCycle){
            return new int[0];
        }

        int[] ret = new int[numCourses];
        int index = 0;
        while (!reversePostOrder.isEmpty()) {
            ret[index++] = reversePostOrder.pop();
        }
        return ret;
    }

    private void dfs(List<Integer>[] adj, int v) {
        marked[v] = true;
        onStack[v] = true;
        if (adj[v] != null) {
            for (int w : adj[v]) {
                if(onStack[w]){
                    hasCycle = true;
                    break;
                }
                if (!marked[w]) {
                    dfs(adj, w);
                }
            }
        }
        reversePostOrder.push(v);
        onStack[v] = false;
    }

    public static void main(String[] args) {
        CourseScheduleII scheduleII = new CourseScheduleII();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] expected = new int[]{0, 1};
        int[] actual = scheduleII.findOrder(numCourses, prerequisites);
        Assert.assertArrayEquals(expected, actual);

        prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        numCourses = 4;
        expected = new int[]{0, 2, 1, 3};
        actual = scheduleII.findOrder(numCourses, prerequisites);
        Assert.assertArrayEquals(expected, actual);

        prerequisites = new int[][]{{1, 0}, {0, 1}};
        numCourses = 2;
        expected = new int[0];
        actual = scheduleII.findOrder(numCourses, prerequisites);
        Assert.assertArrayEquals(expected, actual);

    }
}
