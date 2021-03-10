package array;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        //coner case
        if(nums==null||nums.length==0){
            return new ArrayList<Integer>();
        }
        boolean[] contains = new boolean[nums.length];
        List<Integer> ret = new ArrayList<>();
        for(int n : nums){
            if(contains[n-1]){
                ret.add(n);
            } else {
                contains[n-1] = true;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        FindAllDuplicate fad = new FindAllDuplicate();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);

        List<Integer> actual = fad.findDuplicates(nums);
        Assert.assertEquals(true, actual.containsAll(expected));
        Assert.assertEquals(true, expected.containsAll(actual));


    }
}
