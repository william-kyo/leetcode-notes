package search.backtracking;

import java.util.HashSet;
import java.util.Set;

public class LegalWords {
    // 1. start with consonant
    // 2. do not have consecutive consonants
    // 3. do not have consecutive vowels

    /**
     * backtracking algorithm
     * time: O(n!)
     * space: O(n)
     * @param S
     * @return number of possible combinations
     */
    public int solution(String S) {
        // conner case
        if(S==null || S.length()==0) {
            return 0;
        }
        // possible combinations
        Set<String> ret = new HashSet<>();
        // current combination
        StringBuilder sb = new StringBuilder();
        // visited
        Set<Integer> set = new HashSet<>();
        // enumerate all possible combinations
        backtracking(S, set, ret, sb);
        return ret.size();
    }

    private void backtracking(String S, Set<Integer> set, Set<String> ret, StringBuilder sb) {
        // base case
        if(sb.length()==S.length()) {
            ret.add(sb.toString());
            return;
        }

        for(int i=0; i<S.length(); i++) {
            // if not visited
            if(!set.contains(i) && isValid(sb, S.charAt(i))) {
                sb.append(S.charAt(i));
                set.add(i);
                backtracking(S, set, ret, sb);
                sb.deleteCharAt(sb.length()-1);
                set.remove(i);
            }
        }
    }

    private boolean isValid(StringBuilder sb, char c) {
        // start with consonant
        if(sb.length()==0) {
            return isConsonant(c);
        }
        // do not have consecutive consonants
        if(isConsonant(sb.charAt(sb.length()-1)) && isConsonant(c)) {
            return false;
        }
        // do not have consecutive vowels
        return isConsonant(sb.charAt(sb.length() - 1)) || isConsonant(c);
    }

    private boolean isConsonant(char c) {
        return c!='A' && c!='E' && c!='I' && c!='O' && c!='U';
    }

    public static void main(String[] args) {
        LegalWords legalWords = new LegalWords();
        // S="BAR", ret = 2
        String S = "BAR";
        int ret = legalWords.solution(S);
        System.out.println(ret);
        // S="AABB", ret = 1
        S = "AABB";
        ret = legalWords.solution(S);
        System.out.println(ret);
        // S="AABCY", ret = 6
        S = "AABCY";
        ret = legalWords.solution(S);
        System.out.println(ret);
        // S="AAAB", ret = 0
        S = "AAAB";
        ret = legalWords.solution(S);
        System.out.println(ret);
    }
}
