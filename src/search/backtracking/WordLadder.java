package search.backtracking;

import org.junit.Assert;
import utils.ArrayConvert;

import java.util.*;

/**
 * exceed time limit
 */
public class WordLadder {
    private Map<String,Set<String>> adjacentMap = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        adjacentMap.put(beginWord, new HashSet<>());
        // adjacent map
        for(String s : wordList){
            adjacentMap.put(s, new HashSet<>());
            if(adjacent(beginWord, s)){
                adjacentMap.get(beginWord).add(s);
            }
            for(String w : wordList){
                if(adjacent(s, w)){
                    adjacentMap.get(s).add(w);
                }
            }
        }
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
        if(shortest==Integer.MAX_VALUE){
            return 0;
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

    private boolean adjacent(Set<String> set, String s, String w){
        if(set.contains(w)){
            return false;
        }
        if(s.length()!=w.length()){
            return false;
        }
        return adjacentMap.getOrDefault(s, new HashSet<>()).contains(w);
    }

    private boolean adjacent(String s, String w){
        int differentScore = 0;
        for(int i=0; i<w.length(); i++){
            if(s.charAt(i)!=w.charAt(i)){
                differentScore++;
            }
        }
        return differentScore == 1;
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
