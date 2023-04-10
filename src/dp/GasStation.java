package dp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||gas.length==0) {
            return -1;
        }
        int n = gas.length;
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<n; i++) {
            deque.offerLast(gas[i]-cost[i]);
        }


        for(int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<>(deque);
            int remain = 0;
            for(int j: list) {
                if(remain<0) {
                    break;
                }
                remain += j;
            }
            if(remain>=0) {
                return i;
            }
            Integer last = deque.pollFirst();
            deque.offerLast(last);
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation solution = new GasStation();
        int[] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
