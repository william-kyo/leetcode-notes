package array;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] ret = new int[2];
        if(nums==null||nums.length==0){
            return ret;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==2){
                ret[0] = nums[i];
            }
        }

        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(i+1)){
                ret[1] = i+1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] expected = {2, 3};
        SetMismatch sm = new SetMismatch();
        int[] actual = sm.findErrorNums(nums);
        Assert.assertArrayEquals(expected, actual);

        int[] nums2 = {1, 1};
        int[] expected2 = {1, 2};
        int[] actual2 = sm.findErrorNums(nums2);
        Assert.assertArrayEquals(expected2, actual2);

        int[] nums3 = {3,2,3,4,6,5};
        int[] expected3 = {3, 1};
        int[] actual3 = sm.findErrorNums(nums3);
        Assert.assertArrayEquals(expected3, actual3);


    }


}
