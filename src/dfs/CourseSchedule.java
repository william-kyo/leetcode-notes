package dfs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }
        // 0 unvisite, 1 visiting, -1 visited
        int[] flags = new int[numCourses];
        // if is DAG
        for(int j=0;j<numCourses;j++){
            if(dfs(graph, flags, j)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] flags, int i){
        // visited
        if(-1 == flags[i]){
            return false;
        }
        // visiting
        if(1 == flags[i]){
            return true;
        }
        flags[i] = 1;
        for(int v : graph.get(i)){
            if(dfs(graph, flags, v)){
                return true;
            }
        }

        flags[i] = -1;
        return false;
    }
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses;
        int[][] prerequisites;
        boolean expected, actual;

        numCourses = 2;
        prerequisites = new int[][]{{1, 0}};
        expected = true;
        actual = cs.canFinish(numCourses, prerequisites);
        Assert.assertEquals(expected, actual);

        numCourses = 2;
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        expected = false;
        actual = cs.canFinish(numCourses, prerequisites);
        Assert.assertEquals(expected, actual);



    }
}
