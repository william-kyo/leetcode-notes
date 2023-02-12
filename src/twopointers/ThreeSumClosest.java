package twopointers;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0; i<nums.length-2; i++) {
            int l = i+1;
            int r = nums.length-1;
            int dist = Integer.MAX_VALUE;
            while(l<r) {
                int sum = nums[i]+nums[l]+nums[r];
                if(Math.abs(sum - target) < dist) {
                    dist = Math.abs(sum - target);
                    ret = sum;
                }
                if(sum == target) {
                    break;
                } else if(sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ThreeSumClosest main = new ThreeSumClosest();
        int[] nums = new int[]{1, 1, 1, 0};
        int target = 1;
        int result = main.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
