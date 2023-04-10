package search.backtracking;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i=n-1; i>=0; i--) {
            for(String w: wordDict) {
                if(i+w.length()<=n&&w.equals(s.substring(i, i+w.length()))) {
                    dp[i] = dp[i+w.length()];
                }
                if(dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        // Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        //Output: false
        String s = "catsandog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println(result);

        //Input: s = "applepenapple", wordDict = ["apple","pen"]
        //Output: true
        s = "applepenapple";
        wordDict = List.of("apple","pen");
        result = solution.wordBreak(s, wordDict);
        System.out.println(result);

        //s =
        //"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
        //wordDict =
        //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
        //Output: true
        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        wordDict = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        result = solution.wordBreak(s, wordDict);
        System.out.println(result);
        // s = "abcd"
        //wordDict =
        //["a","b","cd", "abc"]
        //Output: true
        s = "abcd";
        wordDict = List.of("a","b","cd", "abc");
        result = solution.wordBreak(s, wordDict);
        System.out.println(result);
    }
}
