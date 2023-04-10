package dp;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) {
            return false;
        }
        String[][] dp = new String[s1.length()+1][s2.length()+1];
        dp[0][0] = "";
        // fill first column for s1
        for(int i=1; i<=s1.length(); i++) {
            if(s3.charAt(i-1)==s1.charAt(i-1)) {
                dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }
        // fill first row for s2
        for(int i=1; i<=s2.length(); i++) {
            if(s3.charAt(i-1)==s2.charAt(i-1)) {
                dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
            } else {
                dp[0][i] = dp[0][i-1];
            }
        }
        // dp[i][j] longer
        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                String longer1 = dp[i-1][j];
                if(s1.charAt(i-1)==s3.charAt(longer1.length())) {
                    longer1 += s1.charAt(i-1);
                }

                String longer2 = dp[i][j-1];
                if(s2.charAt(j-1)==s3.charAt(longer2.length())) {
                    longer2 += s2.charAt(j-1);
                }

                if(longer2.length()>longer1.length()) {
                    dp[i][j] = longer2;
                } else {
                    dp[i][j] = longer1;
                }
            }
        }
        return s3.equals(dp[s1.length()][s2.length()]);
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));

    }
}
