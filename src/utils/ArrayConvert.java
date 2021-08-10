package utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayConvert {
    public static List<String> convert(String[] array) {
        List<String> list = new ArrayList<>();
        for (String s : array) {
            list.add(s);
        }
        return list;
    }

}
