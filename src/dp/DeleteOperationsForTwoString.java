package dp;

import org.junit.Assert;

public class DeleteOperationsForTwoString {
    public int minDistance(String word1, String word2) {
        if(word1==null||word2==null){
            return 0;
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j]);
                }
            }
        }

        return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationsForTwoString dofts = new DeleteOperationsForTwoString();
        String word1, word2;
        int expected, acutal;

        word1 = "leetcode";
        word2 = "etco";
        acutal = 4;
        expected = dofts.minDistance(word1, word2);
        Assert.assertEquals(expected, acutal);

        word1 = "sea";
        word2 = "eat";
        acutal = 2;
        expected = dofts.minDistance(word1, word2);
        Assert.assertEquals(expected, acutal);

        word1 = "etco";
        word2 = "leetcode";
        acutal = 4;
        expected = dofts.minDistance(word1, word2);
        Assert.assertEquals(expected, acutal);

        word1 = "intention";
        word2 = "execution";
        acutal = 8;
        expected = dofts.minDistance(word1, word2);
        Assert.assertEquals(expected, acutal);

    }
}
