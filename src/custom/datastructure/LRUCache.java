package custom.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final int MAX_CAPACITY;
    private LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        MAX_CAPACITY = capacity;
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CAPACITY;
            }
        };
    }

    public int get(int key) {
        return linkedHashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
    }
}
