package string;

import java.util.*;

public class Multiply {
    public String multiply(String num1, String num2) {
        List<String> tempList = new ArrayList<>();
        for(int i=num1.length()-1; i>=0; i--) {
            StringBuilder sb = new StringBuilder();
            int carrier = 0;
            for (int j = num2.length()-1; j >= 0 ; j--) {
                int t = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carrier;
                carrier = t/10;
                sb.append(t%10);
            }
            if(carrier>0) {
                sb.append(carrier);
            }
            for(int k=num1.length() - 1 - i; k>0; k--) {
                sb.insert(0, "0");
            }
            tempList.add(sb.toString());
        }

        return add(tempList);
    }

    private String add(List<String> list) {
        int maxLen = list.get(list.size()-1).length();
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for(int i=0; i<maxLen; i++) {
            int temp = 0;
            for(String s : list) {
                if(s.length()>=i+1) {
                    temp += s.charAt(i) - '0';
                }
            }
            temp += carrier;
            carrier = temp/10;
            sb.append(temp%10);
        }
        if(carrier>0) {
            sb.append(carrier);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("", new ArrayList<>());
        map.get("").add("super");

        Multiply main = new Multiply();
        String num1 = "123";
        String num2 = "456";
        String ans = main.multiply(num1, num2);
        System.out.println(ans);
    }
}
