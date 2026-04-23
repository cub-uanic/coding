package cub.leetcode.medium.lrucache_146;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public interface LRUCache {
    int get(int key);
    void put(int key, int value);
    LRUCache init(int capacity);
}
