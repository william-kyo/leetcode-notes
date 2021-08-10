package search.backtracking;

import org.junit.Assert;
import utils.ArrayConvert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<Set<String>> ret = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        backtracking(wordList,endWord,list, set,ret);
        // find the shortest ladder
        int shortest = Integer.MAX_VALUE;
        for(Set<String> s: ret){
            if(s.size()>1){
                shortest = Math.min(shortest, s.size());
            }
        }
        return shortest;
    }

    private void backtracking(List<String> wordList, String endWord, List<String> list, Set<String> set, List<Set<String>> ret){
        if(set.contains(endWord)){
            ret.add(new HashSet<>(set));
            return;
        }
        for(String word: wordList){
            if(adjacent(set,list.get(list.size()-1), word)){
                set.add(word);
                list.add(word);
                backtracking(wordList,endWord,list, set,ret);
                set.remove(word);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean adjacent(Set<String> set, String w1, String w2){
        if(set.contains(w2)){
            return false;
        }
        if(w1.length()!=w2.length()){
            return false;
        }
        int differentScore = 0;
        for(int i=0; i<w1.length(); i++){
            if(w1.charAt(i)!=w2.charAt(i)){
                differentScore++;
            }
        }
        return differentScore==1;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String start = "hit";
        String end = "cog";
        List<String> wordList = ArrayConvert.convert(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        int expected = 5;
        int actual = wordLadder.ladderLength(start, end, wordList);
        Assert.assertEquals(expected, actual);

        start = "qa";
        end = "sq";
        wordList = ArrayConvert.convert(new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"});
        actual = wordLadder.ladderLength(start, end, wordList);
        System.out.println(actual);

    }
}
