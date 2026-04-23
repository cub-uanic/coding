package cub.leetcode.medium.lrucache_146;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCacheSolution2 implements LRUCache {
    static class LRUNode {
        int key;
        LRUNode next;

        public LRUNode(int key) {
            this.key = key;
            this.next = null;
        }
    }

    LRUNode lruHead;
    LRUNode lruTail;

    int lruCapacity;

    Map<Integer, Integer> cache;

    public LRUCacheSolution2(int capacity) {
        lruCapacity = capacity;
        lruHead = lruTail = null;
        cache = new HashMap<>(capacity);
    }

    @Override
    public int get(int key) {
        if (cache.containsKey(key)) {
            refreshLRU(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }

    @Override
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            refreshLRU(key);
            cache.put(key, value);
        } else {
            if (cache.size() >= lruCapacity) {
                cache.remove(lruHead.key);
                lruHead = lruHead.next;
            }

            if (cache.isEmpty()) {
                lruHead = lruTail = new LRUNode(key);
            } else {
                lruTail = lruTail.next = new LRUNode(key);
            }
            cache.put(key, value);
        }
    }

    private void refreshLRU(int key) {
        if (lruHead == lruTail) {
            lruHead.key = key;
            return;
        }

        LRUNode prev = null;
        LRUNode curr = lruHead;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            if (curr == lruTail) {
                lruTail.key = key;
            } else {
                if (curr != lruHead) {
                    prev.next = curr.next;
                } else {
                    lruHead = lruHead.next;
                }
                lruTail = lruTail.next = curr;
                curr.next = null;
            }
        } // else do nothing: key to be updated is last (most fresh) already
    }

    @Override
    public LRUCache init(int capacity) {
        return new LRUCacheSolution2(capacity);
    }
}
