import org.junit.Assert;

import java.util.*;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int[] A_Temp = A.clone();
        int[] B_Temp = B.clone();
        Arrays.sort(A_Temp);
        Arrays.sort(B_Temp);

        // match
        Map<Integer/*A*/, Deque<Integer>/*B*/> assignedMap = new HashMap<>();
        for (int b : B) {
            assignedMap.put(b, new LinkedList<>());
        }
        // remain small element in A
        Deque<Integer> remaining = new LinkedList<>();

        int j = 0;
        for (int a : A_Temp) {
            if (a <= B_Temp[j]) {
                remaining.add(a);
            } else {
                assignedMap.get(B_Temp[j++]).add(a);
            }
        }

        // construct result
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            Deque<Integer> l = assignedMap.get(B[i]);
            if (!l.isEmpty()) {
                ans[i] = l.pop();
            } else {
                ans[i] = remaining.pop();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AdvantageShuffle af = new AdvantageShuffle();
        /**
         * Example 1:
         *
         * Input: A = [2,7,11,15], B = [1,10,4,11]
         * Output: [2,11,7,15]
         *
         * Example 2:
         *
         * Input: A = [12,24,8,32], B = [13,25,32,11]
         * Output: [24,32,8,12]
         */
        int[] A = {2, 7, 11, 15};
        int[] B = {1, 10, 4, 11};
        int[] actual = af.advantageCount(A, B);
        int[] expected = new int[]{2, 11, 7, 15};
        assertTrue(expected, actual);

        A = new int[]{12, 24, 8, 32};
        B = new int[]{13, 25, 32, 11};
        actual = af.advantageCount(A, B);
        expected = new int[]{24, 32, 8, 12};
        assertTrue(expected, actual);

        /**
         * [2,0,4,1,2]
         * [1,3,0,0,2]
         */
        A = new int[]{2, 0, 4, 1, 2};
        B = new int[]{1, 3, 0, 0, 2};
        actual = af.advantageCount(A, B);
        expected = new int[]{2, 0, 2, 1, 4};
        assertTrue(expected, actual);
    }

    private static void assertTrue(int[] expected, int[] actual) {
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }
}
