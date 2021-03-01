package randompick;

import java.util.*;

public class Solution {
    int M;
    Set<Integer> set;
    Map<Integer,Integer> map;

    public Solution(int N, int[] blacklist) {
        this.M = N - blacklist.length;

        this.set = new HashSet<>();
        for (Integer i : blacklist) {
            this.set.add(i);
        }

        this.map = new HashMap<>();
        int p = M;
        for (Integer x : blacklist) {
            if (x >= M) {
                continue;
            }
            while (set.contains(p)) {
                p++;
            }
            map.put(x, p);
            p++;
        }
    }

    public int pick() {
        int ans = (int) (Math.random() * M);
        if (set.contains(ans)) {
            return map.get(ans);
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        /**
         * [[1,[]],[],[],[]]
         * Output: [null,0,0,0]
         *
         * [[2,[]],[],[],[]]
         * Output: [null,1,1,1]
         *
         * [[3,[1]],[],[],[]]
         * Output: [null,0,0,2]
         *
         * [[4,[2]],[],[],[]]
         * Output: [null,1,3,1]
         */
        Solution solution = new Solution(4, new int[]{0,2});
        System.out.println(solution.pick());


    }
}
