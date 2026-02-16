package cub.leetcode.medium.lrucache_146;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCacheSolution1 implements LRUCache {
    int lruIndex;
    int lruCapacity;
    int[] lru;
    Map<Integer, Integer> map;

    LRUCacheSolution1(int capacity) {
        lruIndex = 0;
        lruCapacity = capacity;
        lru = new int[capacity];
        map = new HashMap<>(capacity);
    }

    @Override
    public int get(int key) {
        if (map.containsKey(key)) {
            refreshLRU(key);
        }
        return map.getOrDefault(key, -1);
    }

    @Override
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            refreshLRU(key);
            map.put(key, value);
        } else {
            if (lruIndex < lruCapacity) {
                map.put(key, value);
                lru[lruIndex++] = key;
            } else {
                map.remove(lru[0]);
                System.arraycopy(lru, 1, lru, 0, lruCapacity - 1);
                map.put(key, value);
                lru[lruCapacity - 1] = key;
            }
        }
    }

    private void refreshLRU(int key) {
        int i = 0;
        while (i < lruIndex - 1 && lru[i] != key) i++;
        while (i < lruIndex - 1) {
            lru[i] = lru[i + 1];
            i++;
        }
        lru[lruIndex - 1] = key;
    }

    @Override
    public LRUCache init(int capacity) {
        return new LRUCacheSolution1(capacity);
    }
}
