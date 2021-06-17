package search.backtracking;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(n, k, 1, list, ret);
        return ret;
    }

    private void backtracking(int n, int k, int index, List<Integer> list, List<List<Integer>> ret) {
        if (list.size() == k) {
            ret.add(new ArrayList(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            backtracking(n, k, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        int[][] expected = new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {3, 4},
                {2, 3},
                {2, 4}
        };

        List<List<Integer>> ret = combinations.combine(4, 2);
        int[][] actual = convert(ret);
        Assert.assertEquals(expected.length, actual.length);

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        };

        Arrays.sort(expected, comparator);
        Arrays.sort(actual, comparator);

        Assert.assertEquals(expected.length, actual.length);
        for(int i=0; i<expected.length; i++){
            int[] exp = expected[i];

            for(int j=0; j<exp.length; j++){
                int a = actual[i][j];
                Assert.assertEquals(expected[i][j], a);
            }
        }
    }

    private static int[][] convert(List<List<Integer>> list){
        int i = list.size();
        int j = list.get(0).size();
        int[][] ret = new int[i][j];
        int index = 0;
        for (List<Integer> l : list) {
            ret[index++] = l.stream().mapToInt(p -> p).toArray();
        }
        return ret;
    }

}