package order;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int data : nums) {
            pq.add(data);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KLargestElement kle = new KLargestElement();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        int r = kle.findKthLargest(nums, k);
        Assert.assertEquals(5, r);
    }
}
