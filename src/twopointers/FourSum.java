package twopointers;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ret = new HashSet<>();
        for(int i=0; i<nums.length-3; i++) {
            for(int j=i+1; j<nums.length-2; j++) {
                searchQuadruplet(nums, target, i, j, ret);
            }
        }
        return new ArrayList<>(ret);
    }

    private void searchQuadruplet(int[] nums, int target, int first, int second, Set<List<Integer>> ret) {
        int l = second+1;
        int r = nums.length-1;
        while(l<r) {
            int sum = nums[first] + nums[second] + nums[l] + nums[r];
            if(sum == target) {
                ret.add(Arrays.asList(nums[first], nums[second], nums[l], nums[r]));
                l++;
                r--;
            } else if(sum < target) {
                l++;
            } else {
                r--;
            }
        }
    }

    public static void main(String[] args) {
        FourSum main = new FourSum();
        int[] nums = {1000, 1000, 1000, 1000};
        int target = -234;
        List<List<Integer>> ret = main.fourSum(nums, target);
        System.out.println(ret);

    }
}
