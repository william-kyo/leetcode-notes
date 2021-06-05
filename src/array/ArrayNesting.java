package array;

import org.junit.Assert;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if(nums==null||nums.length<1){
            return 0;
        }

        int maxSetLen = 0;
        boolean[] marked = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(!marked[i]){
                int p = i;
                int count = 1;
                while(nums[p]!=i){
                    count++;
                    p = nums[p];
                    marked[p] = true;
                }
                maxSetLen = Math.max(maxSetLen, count);
            }
        }
        return maxSetLen;
    }

    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();

        int[] nums;
        int expected, actual;

        nums = new int[]{5, 4, 0, 3, 1, 6, 2};
        expected = 4;
        actual = arrayNesting.arrayNesting(nums);
        Assert.assertEquals(expected, actual);

        nums = new int[]{0, 1, 2};
        expected = 1;
        actual = arrayNesting.arrayNesting(nums);
        Assert.assertEquals(expected, actual);

    }
}
