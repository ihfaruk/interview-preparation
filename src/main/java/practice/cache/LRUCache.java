package practice.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU cache, is the cache replacement policy,
 * in this case discard the element which is least recently used
 * <p>
 * Data Structure:
 * HashMap for O(1) constant time search
 * Doubly LinkedList for keeping track of least recently used elements with O(1) insert, update, delete operation
 */
public class LRUCache<K, V> {
    private class Node {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.value = value;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    private int size;

    private Map<K, Node> cacheMap = new HashMap<>();

    private Node head;

    private Node tail;

    private int currentCacheSize = 0;

    public LRUCache() {
        this.size = 10;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public LRUCache(int size) {
        this();
        this.size = size;
    }

    public void insert(K key, V value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);

            //Remove the node
            node.prev.next = node.next;
            node.next.prev = node.prev;

        } else {
            if (currentCacheSize >= size) {
                cacheMap.remove(tail.prev.key);
                //remove node previous to tail
                Node tailPrevToPrev = tail.prev.prev;
                tailPrevToPrev.next = tail;
                tail.prev = tailPrevToPrev;
                currentCacheSize = currentCacheSize - 1;

            }

            currentCacheSize = currentCacheSize + 1;
        }
        Node newNode = addNewNode(key, value);
        cacheMap.put(key, newNode);
    }

    private Node addNewNode(K key, V value) {
        //add to the beginning
        Node newNode = new Node(key, value);
        head.next.prev = newNode;
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        return newNode;
    }

    public V get(K key) {
        Node node = cacheMap.get(key);
        if (node != null)
            return node.value;
        return null;
    }

}
