package search.bfs;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int[] inLinkCounts = new int[numCourses];
        // initial inLinkCounts and adjacent list array
        initial(prerequisites, adj, inLinkCounts);

        // queue for BFS traverse
        Queue<Integer> queue = new ArrayDeque<>();
        // add first visited vertex
        for (int v = 0; v < numCourses; v++) {
            if (inLinkCounts[v] == 0) {
                queue.offer(v);
            }
        }
        // index for each vertex
        int visited = 0;
        // order
        int[] order = new int[numCourses];
        // BFS traverse vertex
        while (!queue.isEmpty()) {
            int v = queue.poll();
            order[visited++] = v;
            for (Integer w : adj.get(v)) {
                // how count down in-link-counts: dequeued vertex's adjacent will be count down 1
                inLinkCounts[w]--;
                // when add to queue: vertex that is no in link counts(no dependency)
                if (inLinkCounts[w] == 0) {
                    queue.offer(w);
                }
            }
        }
        // how to find not DAG: can't visited all vertex
        if (visited != numCourses) {
            return new int[0];
        }
        return order;
    }

    private void initial(int[][] prerequisites, List<List<Integer>> adj, int[] inLinkCounts) {
        int n = inLinkCounts.length;
        while (n-- >= 0) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int v = edge[1];
            int w = edge[0];
            adj.get(v).add(w);
            inLinkCounts[w]++;
        }
    }

    public static void main(String[] args) {
        search.dfs.CourseScheduleII scheduleII = new search.dfs.CourseScheduleII();
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
