package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(-1, 0, 1));
        list.add(Arrays.asList(-1, 0, 1));

        System.out.println(list.stream().distinct().collect(Collectors.toList()));

    }
}