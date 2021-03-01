package bit.move;

import org.junit.Assert;

public class MaxProductOfWordLength {
    public int maxProduct(String[] words) {
        if(words==null||words.length<2) return 0;
        int len = words.length;
        String[][] legalWords = new String[len][len-1];
        // fill the legalWords
        for(int i=0; i<len; i++){
            int L = 0;
            for(int j = 0; j<len; j++){
                if(notContainSameChar(words[i],words[j])){
                    legalWords[i][L++] = words[j];
                }
            }
        }
        // find the maxium value
        int max = 0;
        for(int i=0; i<len; i++){
            for(int j=0; j<legalWords[i].length; j++){
                int temp = words[i].length() * legalWords[i][j].length();
                if(temp>max){
                    max = temp;
                }
            }
        }
        return max;
    }

    private boolean notContainSameChar(String a, String b){
        for(char c: a.toCharArray()){
            for(char d: b.toCharArray()){
                if((c^d)==0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MaxProductOfWordLength mpowl = new MaxProductOfWordLength();
        String[] word = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int ret = mpowl.maxProduct(word);
        Assert.assertEquals(16, ret);
    }
}
