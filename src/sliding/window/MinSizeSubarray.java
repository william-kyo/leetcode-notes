package sliding.window;

public class MinSizeSubarray {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums==null) {
            return 0;
        }
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int s = 0;
        for(int e=0; e<n; e++) {
            sum += nums[e];
            if(sum>=target) {
                while(sum>=target) {
                    minLen = Math.min(minLen, e-s+1);
                    sum -= nums[s];
                    s++;
                }
            }
        }
        if(minLen==Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        MinSizeSubarray minSizeSubarray = new MinSizeSubarray();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minSizeSubarray.minSubArrayLen(target, nums));
    }
}
