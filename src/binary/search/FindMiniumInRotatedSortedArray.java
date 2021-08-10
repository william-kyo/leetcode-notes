package binary.search;

import org.junit.Assert;

public class FindMiniumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        while(l<h){
            int mid = l + (h-l)/2;
            if(nums[mid]>nums[h]){
                l = mid+1;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        FindMiniumInRotatedSortedArray findMinium = new FindMiniumInRotatedSortedArray();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int expected = 1;
        int actual = findMinium.findMin(nums);
        Assert.assertEquals(expected, actual);
    }
}
