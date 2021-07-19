package binary.search;

import org.junit.Assert;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }

            }
            if (count <= mid) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FindDuplicate fp = new FindDuplicate();
        int[] nums;
        int expecte, actual;

        nums = new int[]{2, 2, 1, 4, 3};
        expecte = 2;
        actual = fp.findDuplicate(nums);
        Assert.assertEquals(expecte, actual);

        nums = new int[]{2, 1, 4, 3, 1};
        expecte = 1;
        actual = fp.findDuplicate(nums);
        Assert.assertEquals(expecte, actual);

        nums = new int[]{4, 2, 3, 4, 1, 5, 6};
        expecte = 4;
        actual = fp.findDuplicate(nums);
        Assert.assertEquals(expecte, actual);



    }
}
