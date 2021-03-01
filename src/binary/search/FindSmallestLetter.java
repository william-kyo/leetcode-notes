package binary.search;

import org.junit.Assert;

public class FindSmallestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while(left < right){
            System.out.println("L -> " + left + " ; R -> " + right);
            int mid = left + (right - left) / 2;
            System.out.println("mid -> " + mid);
            // 查找比target大
            if(letters[mid]<=target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == right && target >= letters[left]) {
            return letters[0];
        }
        return letters[right];
    }

    public static void main(String[] args) {
        FindSmallestLetter findSmallestLetter = new FindSmallestLetter();
        char[] letters = new char[]{'c', 'f', 'j'};
        char target, expected, actual;

        target = 'a';
        expected = 'c';
        actual = findSmallestLetter.nextGreatestLetter(letters, target);
        Assert.assertEquals(expected, actual);

        target = 'c';
        expected = 'f';
        actual = findSmallestLetter.nextGreatestLetter(letters, target);
        Assert.assertEquals(expected, actual);

        target = 'j';
        expected = 'c';
        actual = findSmallestLetter.nextGreatestLetter(letters, target);
        Assert.assertEquals(expected, actual);

        target = 'k';
        expected = 'c';
        actual = findSmallestLetter.nextGreatestLetter(letters, target);
        Assert.assertEquals(expected, actual);


    }
}
