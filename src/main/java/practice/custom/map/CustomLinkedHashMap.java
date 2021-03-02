package practice.custom.map;

import java.util.ArrayList;
import java.util.List;

public class CustomLinkedHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;

        Node nextValueNode;

        Node prevLinkedNode;

        Node nextLinkedNode;
    }

    private Node[] mapArray;

    private int size;

    private Node head;
    private Node tail;

    public CustomLinkedHashMap() {
        this.size = 10;
        this.mapArray = new Node[size];
        head = new Node<K, V>();
        tail = new Node<K, V>();
        head.nextLinkedNode = tail;
        tail.prevLinkedNode = head;
    }

    public void put(K key, V value) {
        if (key == null) {

        }

        int hashCode = key.hashCode();
        int index = (hashCode < 0 ? -hashCode : hashCode) % size;
        Node<K, V> tempNode = mapArray[index];
        if (tempNode == null) {
            tempNode = new Node<K, V>();
            tempNode.key = key;
            tempNode.value = value;
            Node tailPreviousNode = tail.prevLinkedNode;
            tailPreviousNode.nextLinkedNode = tempNode;
            tempNode.prevLinkedNode = tailPreviousNode;
            tempNode.nextLinkedNode = tail;
            tail.prevLinkedNode = tempNode;
            mapArray[index] = tempNode;
        } else {
            Node<K, V> tNode = tempNode;
            while (tNode.nextValueNode != null) {
                tNode = tNode.nextValueNode;
            }

            Node<K, V> newNode = new Node<K, V>();
            newNode.key = key;
            newNode.value = value;
            Node<K, V> tailPreviousNode = tail.prevLinkedNode;
            tailPreviousNode.nextLinkedNode = newNode;
            newNode.prevLinkedNode = tailPreviousNode;
            newNode.nextLinkedNode = tail;
            tail.prevLinkedNode = newNode;
            tNode.nextValueNode = newNode;
        }
    }

    public V get(K key) {
        if (key == null) {

        }

        int hashCode = key.hashCode();
        int index = (hashCode < 0 ? -hashCode : hashCode) % size;
        Node<K, V> node = mapArray[index];
        if (node != null) {
            Node<K, V> tempNode = node;
            while (tempNode != null) {
                if (tempNode.key.equals(key)) {
                    return tempNode.value;
                } else {
                    tempNode = tempNode.nextValueNode;
                }
            }
        }
        return null;
    }

    public List<K> keySet() {
        Node<K, V> tempNode = head.nextLinkedNode;
        List<K> list = new ArrayList<>();
        while (tempNode != null && tempNode.key != null) {
            list.add(tempNode.key);
            tempNode = tempNode.nextLinkedNode;
        }

        return list;
    }

}
