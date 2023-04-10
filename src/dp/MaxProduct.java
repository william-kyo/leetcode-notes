package dp;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[1] = nums[0];

        for(int i=2; i<=nums.length; i++) {
            dp[i] = Math.max(dp[i], nums[i-1]);
            dp[i] = Math.max(dp[i], nums[i-1] * nums[i-2]);
            dp[i] = Math.max(dp[i], nums[i-1] * nums[i-2] * dp[i-2]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int[] nums = new int[] {2,-5,-2,-4,3};
        int result = solution.maxProduct(nums);
        System.out.println(result);

        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        Iterator<Integer> iterator = deque.iterator();
        while(iterator.hasNext()) {
            Integer i = iterator.next();
        }
    }
}
