package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<String> list = new ArrayList<>();
        // first element must be 0
        StringBuilder zero = new StringBuilder();
        for(int i=0; i<n; i++) {
            zero.append("0");
        }
        list.add(zero.toString());
        backtracking(list, new StringBuilder(), 0, n);
        List<Integer> ret = new ArrayList<>();
        for(String s: list) {
            ret.add(Integer.parseInt(s, 2));
        }
        return ret;
    }

    private void backtracking(List<String> list, StringBuilder sb, int index, int n){
        if(sb.length()==n&&!list.contains(sb.toString())&&differOneBit(list.get(list.size()-1),sb.toString())) {
            list.add(sb.toString());
            return;
        }
        for(int i=index; i<n; i++) {
            backtracking(list, sb.append("0"), i+1, n);
            sb.deleteCharAt(sb.length()-1);
            backtracking(list, sb.append("1"), i+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private boolean differOneBit(String last, String current){
        int differ = 0;
        for(int i=0; i<last.length(); i++){
            if(last.charAt(i)!=current.charAt(i)) {
                differ++;
            }
        }
        return differ==1;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        List<Integer> ret = grayCode.grayCode(2);
        System.out.println(ret);
    }
}
