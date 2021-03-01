package utils;

import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class MyArrayUtil {
    public static void assertArray(int[] expected, int[] actual) {
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }

    public static <T extends Comparable<? super T>> void assertArray(List<T> expected, List<T> actual) {
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.size(), actual.size());
        Collections.sort(expected);
        Collections.sort(actual);
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

}
