package cub.leetcode.medium.lrucache_146;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCacheSolution3 implements LRUCache {
    static class LRUNode implements Comparable<LRUNode> {
        static int lastUsedIndex = 0;
        int key;
        int index;

        public LRUNode(int key) {
            this.key = key;
            this.index = lastUsedIndex++;
        }

        @Override
        public int compareTo(@NotNull LRUNode o) {
            if (this.key == o.key) return 0;
            return Integer.compare(this.index, o.index);
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LRUNode lruNode)) return false;
            return this.key == lruNode.key;
        }

        @Override
        public int hashCode() {
            return this.key;
        }
    }

    Map<Integer, Integer> lruNodesMap = new HashMap<>();
    SortedSet<LRUNode> lruNodes = new TreeSet<>();
    Map<Integer, Integer> cache;
    int lruCapacity;

    public LRUCacheSolution3(int capacity) {
        lruCapacity = capacity;
        cache = new HashMap<>(capacity);
        lruNodesMap =new HashMap<>(capacity);
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
                LRUNode oldest = lruNodes.first();
                lruNodes.remove(oldest);
                lruNodesMap.remove(oldest.key);
                cache.remove(oldest.key);
            }

            LRUNode newNode = new LRUNode(key);
            lruNodes.add(newNode);
            lruNodesMap.put(key, newNode.index);
            cache.put(key, value);
        }
    }

    private void refreshLRU(int key) {
        LRUNode nodeToDelete = new LRUNode(key);
        nodeToDelete.index = lruNodesMap.get(key);
        lruNodes.remove(nodeToDelete);
        lruNodesMap.remove(key);

        LRUNode nodeToAdd = new LRUNode(key);
        lruNodes.add(nodeToAdd);
        lruNodesMap.put(key, nodeToAdd.index);
    }

    @Override
    public LRUCache init(int capacity) {
        return new LRUCacheSolution3(capacity);
    }
}
