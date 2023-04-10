package order;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for(int n: nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(treeMap.containsKey(entry.getValue())) {
                treeMap.get(entry.getValue()).add(entry.getKey());
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                treeMap.put(entry.getValue(), list);
            }

        }
        int[] ret = new int[k];
        int p = 0;
        for(Map.Entry<Integer,List<Integer>> entry : treeMap.entrySet()) {
            for(int v: entry.getValue()) {
                if(p<k){
                    ret[p] = v;
                    p++;
                }
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
