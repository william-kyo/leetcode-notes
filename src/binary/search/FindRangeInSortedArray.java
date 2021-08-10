package binary.search;

import org.junit.Assert;

public class FindRangeInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int l = 0;
        int h = nums.length;
        while(l<h){
            int mid = l + (h-l)/2;
            if(nums[mid]<target){
                l = mid+1;
            } else {
                h = mid;
            }
        }
        if(l>=nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }
        // find the last position
        int last = l;
        int p = l;
        while(p<nums.length){
            if(nums[p]==target){
                last = p;
            }
            p++;
        }
        return new int[]{l, last};
    }

    public static void main(String[] args) {
        int i = 2;
        System.out.println((i & 1) == 0);
        int[] nums;
        int target;
        int[] expected, actual;
        FindRangeInSortedArray fr = new FindRangeInSortedArray();

        nums = new int[]{2,3,4,4,5};
        target = 4;
        expected = new int[]{2, 3};
        actual = fr.searchRange(nums, target);
        Assert.assertArrayEquals(expected, actual);

    }
}
