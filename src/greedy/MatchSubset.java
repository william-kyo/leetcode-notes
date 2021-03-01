package greedy;

public class MatchSubset {
    public boolean isSubsequence(String s, String t) {
        // corner case
        int pre = -1;
        int count = 0;
        for(char c: s.toCharArray()){
            for(int i=pre+1; i<t.length(); i++){
                if(c==t.charAt(i)){
                    pre = i;
                    count++;
                    break;
                }
            }
        }
        return count==s.length();
    }

    public static void main(String[] args) {
        MatchSubset ms = new MatchSubset();
        String s = "abc";
        String t = "ahhhcb";
        boolean b = ms.isSubsequence(s, t);
        System.out.println(b);
    }
}
