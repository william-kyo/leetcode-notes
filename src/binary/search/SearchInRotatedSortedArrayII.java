package binary.search;

public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        // find the pivot
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[right]) {
                left = mid + 1;
            } else if(nums[mid]<nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        int bottom = left;

        // decide the left and right range
        left = 0;
        right = nums.length-1;
        if(target>=nums[bottom]&&target<=nums[right]) {
            left = bottom;
        } else {
            right = bottom - 1;
        }
        // binary search target
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(target==nums[mid]) {
                return true;
            }
            if(target>nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 3, 2, 2, 2};
        int target = 3;
        boolean ret = search(nums, target);
        System.out.println(ret);
    }
}
