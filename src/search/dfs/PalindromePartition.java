package search.dfs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        List<String> current = new ArrayList<>();
        dfs(ret, current, s, 0);
        return ret;
    }

    private void dfs(List<List<String>> ret, List<String> current, String s, int start){
        // goal
        if(start>=s.length()){
            ret.add(new ArrayList<>(current));
        }
        // constraint: end of a string
        // preorder
        for(int end=start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                current.add(s.substring(start, end+1));
                dfs(ret, current, s, end+1);
                current.remove(current.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end){

        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition pp = new PalindromePartition();
        String s = "aba";
        String[][] expected = new String[][]{{"a", "b", "a"}, {"aba"}};
        List<List<String>> actual = pp.partition(s);
        assertEquals(expected, actual);

        s = "aab";
        expected = new String[][]{{"a", "a", "b"}, {"aa", "b"}};
        actual = pp.partition(s);
        assertEquals(expected, actual);

    }

    private static void assertEquals(String[][] expected, List<List<String>> actual) {
        Assert.assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i].length, actual.get(i).size());
            for (int j = 0; j < expected[i].length; j++) {
                Assert.assertEquals(expected[i][j], actual.get(i).get(j));
            }
        }
    }
}
